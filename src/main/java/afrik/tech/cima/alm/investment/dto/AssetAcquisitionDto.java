package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetAcquisitionDto(Long id, @NotBlank String code, @NotBlank String libelle, Long compagnieId,
                                  Long filialeId, Long typeActifId, Long categorieActifId, Long deviseId,
                                  BigDecimal montantNominal, LocalDate dateSoumission, LocalDate dateAutorisation,
                                  LocalDate dateValidation, String statut, String gestionnaire, String daf,
                                  String dg, String motifRejet) {
}
