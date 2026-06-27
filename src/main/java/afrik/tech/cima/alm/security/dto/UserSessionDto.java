package afrik.tech.cima.alm.security.dto;

import java.time.OffsetDateTime;

public record UserSessionDto(Long id, Long userId, String sessionToken, String ipAddress, String userAgent,
                             OffsetDateTime expiresAt, OffsetDateTime revokedAt, Boolean active) {
}
