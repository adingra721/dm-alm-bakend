package afrik.tech.cima.alm.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CountryDto(Long id, @NotBlank String code, @NotBlank String libelle, String description,
                         Boolean actif, @Size(max = 3) String codeIso3, String zoneCima) {
}
