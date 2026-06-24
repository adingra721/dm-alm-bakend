package afrik.tech.cima.alm.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubsidiaryDto(Long id, @NotBlank String code, @NotBlank String libelle, @NotNull Long compagnieId,
                            Long paysId, Long adresseId, Boolean actif) {
}
