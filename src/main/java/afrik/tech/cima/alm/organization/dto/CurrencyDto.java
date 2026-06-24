package afrik.tech.cima.alm.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CurrencyDto(Long id, @NotBlank String code, @NotBlank String libelle, String description,
                          Boolean actif, @NotBlank @Size(max = 3) String codeIso, String symbole) {
}
