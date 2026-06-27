package afrik.tech.cima.alm.almreference.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FinancialAssetTypeDto(
        Long id,
        @NotBlank @Size(max = 60) String code,
        @NotBlank @Size(max = 150) String libelle,
        @Size(max = 500) String description,
        Boolean actif,
        Long categorieActifId,
        String categorieActifLibelle
) {
}
