package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AssetRatingDto(Long id, Long actifId, @NotBlank String agence, String noteEmetteur, String notePays,
                             LocalDate dateNotation, String perspective, String commentaire) {
}
