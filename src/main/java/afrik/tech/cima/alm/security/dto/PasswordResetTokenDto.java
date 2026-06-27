package afrik.tech.cima.alm.security.dto;

import java.time.OffsetDateTime;

public record PasswordResetTokenDto(Long id, Long userId, String tokenHash, OffsetDateTime expiresAt,
                                    OffsetDateTime usedAt) {
}
