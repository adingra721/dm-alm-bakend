package afrik.tech.cima.alm.security.dto;

import java.time.OffsetDateTime;

public record AuthResponse(String accessToken, String refreshToken, OffsetDateTime expiresAt, AppUserDto user) {
}
