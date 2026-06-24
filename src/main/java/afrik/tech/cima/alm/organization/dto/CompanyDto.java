package afrik.tech.cima.alm.organization.dto;

import jakarta.validation.constraints.NotBlank;

public record CompanyDto(Long id, @NotBlank String code, @NotBlank String raisonSociale, String numeroAgrement,
                         Long paysId, Long deviseFonctionnelleId, Long adresseSiegeId, Boolean actif) {
}
