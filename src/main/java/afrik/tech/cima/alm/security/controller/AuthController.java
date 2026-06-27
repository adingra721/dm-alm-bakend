package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.security.dto.AppUserDto;
import afrik.tech.cima.alm.security.dto.AuthResponse;
import afrik.tech.cima.alm.security.dto.ChangePasswordRequest;
import afrik.tech.cima.alm.security.dto.LoginRequest;
import afrik.tech.cima.alm.security.dto.PasswordResetConfirmRequest;
import afrik.tech.cima.alm.security.dto.PasswordResetRequest;
import afrik.tech.cima.alm.security.dto.RefreshTokenRequest;
import afrik.tech.cima.alm.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request, HttpServletRequest servletRequest) {
        return service.login(request, servletRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authorization, HttpServletRequest request) {
        service.logout(authorization, request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/refresh-token")
    public AuthResponse refresh(@Valid @RequestBody RefreshTokenRequest request, HttpServletRequest servletRequest) {
        return service.refresh(request, servletRequest);
    }

    @GetMapping("/me")
    public AppUserDto me(@RequestHeader("Authorization") String authorization) {
        return service.me(authorization);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@RequestHeader("Authorization") String authorization,
                                               @Valid @RequestBody ChangePasswordRequest request,
                                               HttpServletRequest servletRequest) {
        service.changePassword(authorization, request, servletRequest);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/password-reset/request")
    public String requestPasswordReset(@Valid @RequestBody PasswordResetRequest request, HttpServletRequest servletRequest) {
        return service.requestPasswordReset(request, servletRequest);
    }

    @PostMapping("/password-reset/confirm")
    public ResponseEntity<Void> confirmPasswordReset(@Valid @RequestBody PasswordResetConfirmRequest request,
                                                     HttpServletRequest servletRequest) {
        service.confirmPasswordReset(request, servletRequest);
        return ResponseEntity.noContent().build();
    }
}
