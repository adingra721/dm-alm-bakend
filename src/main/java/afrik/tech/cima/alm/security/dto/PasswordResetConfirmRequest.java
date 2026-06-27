package afrik.tech.cima.alm.security.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordResetConfirmRequest(@NotBlank String token, @NotBlank String newPassword) {
}
