package afrik.tech.cima.alm.investment.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inv_acquisitions_actifs")
public class AssetAcquisition extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String code;

    @Column(nullable = false, length = 180)
    private String libelle;

    private Long compagnieId;
    private Long filialeId;
    private Long typeActifId;
    private Long categorieActifId;
    private Long deviseId;

    @Column(precision = 19, scale = 4)
    private BigDecimal montantNominal;

    private LocalDate dateSoumission;
    private LocalDate dateAutorisation;
    private LocalDate dateValidation;

    @Column(nullable = false, length = 40)
    private String statut = "BROUILLON";

    @Column(length = 120)
    private String gestionnaire;

    @Column(length = 120)
    private String daf;

    @Column(length = 120)
    private String dg;

    @Column(length = 500)
    private String motifRejet;
}
