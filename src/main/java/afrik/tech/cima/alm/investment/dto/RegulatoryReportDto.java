package afrik.tech.cima.alm.investment.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegulatoryReportDto(Long id, @NotBlank String codeEtat, @NotBlank String libelle, Long compagnieId,
                                  LocalDate periodeDebut, LocalDate periodeFin, String statut,
                                  String fichierGenere, String commentaire) {
}
