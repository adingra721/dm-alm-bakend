package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

public record AssetDocumentDto(Long id, Long acquisitionId, Long actifId, @NotBlank String typeDocument,
                               @NotBlank String nomFichier, String referenceStockage, Boolean obligatoire,
                               Boolean valide) {
}
