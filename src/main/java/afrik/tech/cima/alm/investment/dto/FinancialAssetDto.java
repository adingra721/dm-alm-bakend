package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FinancialAssetDto(Long id, @NotBlank String code, @NotBlank String libelle, Long acquisitionId,
                                Long compagnieId, Long filialeId, Long typeActifId, Long categorieActifId,
                                Long paysEmetteurId, Long deviseId, String emetteur, BigDecimal valeurNominale,
                                BigDecimal valeurAcquisition, BigDecimal tauxCoupon, LocalDate dateAcquisition,
                                LocalDate dateEcheance, String statut, Boolean actif) {
}
