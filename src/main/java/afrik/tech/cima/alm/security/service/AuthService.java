package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.exception.ResourceNotFoundException;
import afrik.tech.cima.alm.common.exception.AuthenticationFailedException;
import afrik.tech.cima.alm.security.dto.AppUserDto;
import afrik.tech.cima.alm.security.dto.AuthResponse;
import afrik.tech.cima.alm.security.dto.ChangePasswordRequest;
import afrik.tech.cima.alm.security.dto.LoginRequest;
import afrik.tech.cima.alm.security.dto.PasswordResetConfirmRequest;
import afrik.tech.cima.alm.security.dto.PasswordResetRequest;
import afrik.tech.cima.alm.security.dto.RefreshTokenRequest;
import afrik.tech.cima.alm.security.entity.AppUser;
import afrik.tech.cima.alm.security.entity.PasswordResetToken;
import afrik.tech.cima.alm.security.entity.RefreshToken;
import afrik.tech.cima.alm.security.entity.UserSession;
import afrik.tech.cima.alm.security.mapper.AppUserMapper;
import afrik.tech.cima.alm.security.repository.AppUserRepository;
import afrik.tech.cima.alm.security.repository.PasswordResetTokenRepository;
import afrik.tech.cima.alm.security.repository.RefreshTokenRepository;
import afrik.tech.cima.alm.security.repository.UserSessionRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class AuthService {

    private static final int ACCESS_TOKEN_MINUTES = 30;
    private static final int REFRESH_TOKEN_DAYS = 7;

    private final AppUserRepository userRepository;
    private final UserSessionRepository sessionRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final AppUserMapper userMapper;
    private final PasswordService passwordService;
    private final TokenService tokenService;
    private final SecurityAuditService auditService;

    public AuthService(AppUserRepository userRepository, UserSessionRepository sessionRepository,
                       RefreshTokenRepository refreshTokenRepository,
                       PasswordResetTokenRepository passwordResetTokenRepository, AppUserMapper userMapper,
                       PasswordService passwordService, TokenService tokenService, SecurityAuditService auditService) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.userMapper = userMapper;
        this.passwordService = passwordService;
        this.tokenService = tokenService;
        this.auditService = auditService;
    }

    @Transactional
    public AuthResponse login(LoginRequest request, HttpServletRequest servletRequest) {
        AppUser user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new AuthenticationFailedException("Identifiants invalides"));
        normalizeSecurityDefaults(user);
        if (!Boolean.TRUE.equals(user.getActif()) || isLocked(user)) {
            auditService.log(user, "LOGIN_BLOCKED", "USER", user.getId().toString(), "Compte inactif ou verrouille", servletRequest);
            throw new ResourceNotFoundException("Compte inactif ou verrouille");
        }
        if (!passwordService.matches(request.password(), user.getPasswordHash())) {
            user.setFailedLoginAttempts((user.getFailedLoginAttempts() == null ? 0 : user.getFailedLoginAttempts()) + 1);
            if (user.getFailedLoginAttempts() >= 5) {
                user.setLockedUntil(OffsetDateTime.now(ZoneOffset.UTC).plusMinutes(15));
            }
            userRepository.save(user);
            auditService.log(user, "LOGIN_FAILED", "USER", user.getId().toString(), "Mot de passe incorrect", servletRequest);
            throw new AuthenticationFailedException("Identifiants invalides");
        }

        user.setFailedLoginAttempts(0);
        user.setLockedUntil(null);
        user.setPasswordChangeRequired(Boolean.TRUE.equals(user.getPasswordChangeRequired()));
        user.setLastLoginAt(OffsetDateTime.now(ZoneOffset.UTC));
        userRepository.save(user);

        OffsetDateTime accessExpiresAt = OffsetDateTime.now(ZoneOffset.UTC).plusMinutes(ACCESS_TOKEN_MINUTES);
        String accessToken = tokenService.createAccessToken(user, accessExpiresAt);
        String refreshToken = tokenService.createOpaqueToken();

        UserSession session = new UserSession();
        session.setUserId(user.getId());
        session.setSessionToken(accessToken);
        session.setIpAddress(servletRequest.getRemoteAddr());
        session.setUserAgent(servletRequest.getHeader("User-Agent"));
        session.setExpiresAt(accessExpiresAt);
        sessionRepository.save(session);

        RefreshToken refresh = new RefreshToken();
        refresh.setUserId(user.getId());
        refresh.setTokenHash(tokenService.hashOpaqueToken(refreshToken));
        refresh.setExpiresAt(OffsetDateTime.now(ZoneOffset.UTC).plusDays(REFRESH_TOKEN_DAYS));
        refreshTokenRepository.save(refresh);

        auditService.log(user, "LOGIN_SUCCESS", "USER", user.getId().toString(), "Connexion reussie", servletRequest);
        return new AuthResponse(accessToken, refreshToken, accessExpiresAt, userMapper.toDto(user));
    }

    @Transactional
    public void logout(String authorizationHeader, HttpServletRequest request) {
        String accessToken = extractBearer(authorizationHeader);
        sessionRepository.findBySessionTokenAndActiveTrue(accessToken).ifPresent(session -> {
            session.setActive(false);
            session.setRevokedAt(OffsetDateTime.now(ZoneOffset.UTC));
            sessionRepository.save(session);
            userRepository.findById(session.getUserId())
                    .ifPresent(user -> auditService.log(user, "LOGOUT", "SESSION", session.getId().toString(), "Deconnexion", request));
        });
    }

    @Transactional
    public AuthResponse refresh(RefreshTokenRequest request, HttpServletRequest servletRequest) {
        String tokenHash = tokenService.hashOpaqueToken(request.refreshToken());
        RefreshToken refresh = refreshTokenRepository.findByTokenHashAndActiveTrue(tokenHash)
                .orElseThrow(() -> new ResourceNotFoundException("Refresh token invalide"));
        if (refresh.getExpiresAt() != null && refresh.getExpiresAt().isBefore(OffsetDateTime.now(ZoneOffset.UTC))) {
            refresh.setActive(false);
            refreshTokenRepository.save(refresh);
            throw new ResourceNotFoundException("Refresh token expire");
        }
        AppUser user = userRepository.findById(refresh.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));
        OffsetDateTime expiresAt = OffsetDateTime.now(ZoneOffset.UTC).plusMinutes(ACCESS_TOKEN_MINUTES);
        String accessToken = tokenService.createAccessToken(user, expiresAt);
        auditService.log(user, "TOKEN_REFRESH", "USER", user.getId().toString(), "Renouvellement access token", servletRequest);
        return new AuthResponse(accessToken, request.refreshToken(), expiresAt, userMapper.toDto(user));
    }

    @Transactional(readOnly = true)
    public AppUserDto me(String authorizationHeader) {
        AppUser user = currentUser(authorizationHeader);
        return userMapper.toDto(user);
    }

    @Transactional
    public void changePassword(String authorizationHeader, ChangePasswordRequest request, HttpServletRequest servletRequest) {
        AppUser user = currentUser(authorizationHeader);
        normalizeSecurityDefaults(user);
        if (!passwordService.matches(request.currentPassword(), user.getPasswordHash())) {
            throw new ResourceNotFoundException("Mot de passe courant invalide");
        }
        user.setPasswordHash(passwordService.hash(request.newPassword()));
        user.setPasswordChangeRequired(false);
        userRepository.save(user);
        auditService.log(user, "PASSWORD_CHANGED", "USER", user.getId().toString(), "Changement mot de passe", servletRequest);
    }

    @Transactional
    public String requestPasswordReset(PasswordResetRequest request, HttpServletRequest servletRequest) {
        AppUser user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));
        String token = tokenService.createOpaqueToken();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setUserId(user.getId());
        resetToken.setTokenHash(tokenService.hashOpaqueToken(token));
        resetToken.setExpiresAt(OffsetDateTime.now(ZoneOffset.UTC).plusHours(2));
        passwordResetTokenRepository.save(resetToken);
        auditService.log(user, "PASSWORD_RESET_REQUESTED", "USER", user.getId().toString(), "Demande reset password", servletRequest);
        return token;
    }

    @Transactional
    public void confirmPasswordReset(PasswordResetConfirmRequest request, HttpServletRequest servletRequest) {
        PasswordResetToken token = passwordResetTokenRepository.findByTokenHash(tokenService.hashOpaqueToken(request.token()))
                .orElseThrow(() -> new ResourceNotFoundException("Token invalide"));
        if (token.getUsedAt() != null || token.getExpiresAt().isBefore(OffsetDateTime.now(ZoneOffset.UTC))) {
            throw new ResourceNotFoundException("Token expire ou deja utilise");
        }
        AppUser user = userRepository.findById(token.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));
        normalizeSecurityDefaults(user);
        user.setPasswordHash(passwordService.hash(request.newPassword()));
        user.setPasswordChangeRequired(false);
        userRepository.save(user);
        token.setUsedAt(OffsetDateTime.now(ZoneOffset.UTC));
        passwordResetTokenRepository.save(token);
        auditService.log(user, "PASSWORD_RESET_CONFIRMED", "USER", user.getId().toString(), "Reset password confirme", servletRequest);
    }

    public AppUser currentUser(String authorizationHeader) {
        String accessToken = extractBearer(authorizationHeader);
        Long userId = tokenService.validateAccessToken(accessToken)
                .orElseThrow(() -> new ResourceNotFoundException("Token invalide"));
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur introuvable"));
    }

    private boolean isLocked(AppUser user) {
        return user.getLockedUntil() != null && user.getLockedUntil().isAfter(OffsetDateTime.now(ZoneOffset.UTC));
    }

    private void normalizeSecurityDefaults(AppUser user) {
        if (user.getFailedLoginAttempts() == null) {
            user.setFailedLoginAttempts(0);
        }
        if (user.getPasswordChangeRequired() == null) {
            user.setPasswordChangeRequired(false);
        }
        if (user.getActif() == null) {
            user.setActif(true);
        }
    }

    private String extractBearer(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ResourceNotFoundException("Token manquant");
        }
        return authorizationHeader.substring("Bearer ".length());
    }
}
