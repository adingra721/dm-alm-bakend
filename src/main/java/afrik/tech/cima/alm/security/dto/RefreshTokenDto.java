package afrik.tech.cima.alm.security.dto;

import java.time.OffsetDateTime;

public record RefreshTokenDto(Long id, Long userId, String tokenHash, OffsetDateTime expiresAt,
                              OffsetDateTime revokedAt, Boolean active) {
}
