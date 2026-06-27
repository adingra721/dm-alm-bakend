package afrik.tech.cima.alm.security.dto;

import jakarta.validation.constraints.NotBlank;

public record AuditLogDto(Long id, Long userId, String username, @NotBlank String action, String resourceType,
                          String resourceId, String ipAddress, String userAgent, String details) {
}
