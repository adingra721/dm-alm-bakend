package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountingMappingDto(Long id, @NotBlank String typeOperation, Long categorieActifId,
                                   @NotBlank String compteDebit, @NotBlank String compteCredit, String journalCode,
                                   String libelle, Boolean actif) {
}
