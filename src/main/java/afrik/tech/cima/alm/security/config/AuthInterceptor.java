package afrik.tech.cima.alm.security.config;

import afrik.tech.cima.alm.security.repository.AppUserRepository;
import afrik.tech.cima.alm.security.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;
    private final AppUserRepository userRepository;

    public AuthInterceptor(TokenService tokenService, AppUserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod()) || isPublic(request.getRequestURI())) {
            return true;
        }
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token manquant");
            return false;
        }
        String token = authorization.substring("Bearer ".length());
        return tokenService.validateAccessToken(token)
                .flatMap(userRepository::findById)
                .filter(user -> Boolean.TRUE.equals(user.getActif()))
                .map(user -> {
                    request.setAttribute("authenticatedUser", user);
                    return true;
                })
                .orElseGet(() -> {
                    try {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token invalide");
                    } catch (Exception ignored) {
                        // handled by servlet container
                    }
                    return false;
                });
    }

    private boolean isPublic(String uri) {
        return uri.startsWith("/api/v1/auth/login")
                || uri.startsWith("/api/v1/auth/refresh-token")
                || uri.startsWith("/api/v1/auth/password-reset")
                || uri.startsWith("/swagger-ui")
                || uri.startsWith("/v3/api-docs")
                || uri.startsWith("/actuator")
                || "/api/v1".equals(uri)
                || "/error".equals(uri);
    }
}
