package afrik.tech.cima.alm.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AppUserDto(Long id, @NotBlank String username, @NotBlank @Email String email,
                         @NotBlank String nomComplet, String passwordHash, Long profilId, Boolean actif) {
}
