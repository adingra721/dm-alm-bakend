package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetMaturityDto(Long id, Long actifId, @NotBlank String typeTombee, LocalDate datePrevue,
                               LocalDate dateReception, BigDecimal montantAttendu, BigDecimal montantRecu,
                               String statut, String referencePiece, String commentaire) {
}
