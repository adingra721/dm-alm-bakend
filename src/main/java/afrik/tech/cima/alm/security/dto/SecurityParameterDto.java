package afrik.tech.cima.alm.security.dto;

import jakarta.validation.constraints.NotBlank;

public record SecurityParameterDto(Long id, @NotBlank String code, @NotBlank String libelle,
                                   @NotBlank String valeur, String description, Boolean actif) {
}
