package afrik.tech.cima.alm.investment.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AmortizationScheduleDto(Long id, Long actifId, Integer numeroEcheance, LocalDate dateEcheance,
                                      BigDecimal capitalDebut, BigDecimal interet, BigDecimal amortissement,
                                      BigDecimal capitalFin, String statut) {
}
