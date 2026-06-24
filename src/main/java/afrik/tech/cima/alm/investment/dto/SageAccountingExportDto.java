package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SageAccountingExportDto(Long id, @NotBlank String referenceExport, Long compagnieId,
                                      LocalDate periodeDebut, LocalDate periodeFin, String formatCible,
                                      String modeExport, String statut, Integer nombreEcritures,
                                      BigDecimal montantTotal, String fichierGenere, String messageErreur) {
}
