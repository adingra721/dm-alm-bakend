package afrik.tech.cima.alm.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AppUserDto(Long id, @NotBlank String username, @NotBlank @Email String email,
                         @NotBlank String nomComplet, String passwordHash, Boolean passwordChangeRequired,
                         Integer failedLoginAttempts, java.time.OffsetDateTime lockedUntil,
                         java.time.OffsetDateTime lastLoginAt, Long profilId, String profilLibelle,
                         Long filialeId, String filialeLibelle, Boolean actif) {
}
