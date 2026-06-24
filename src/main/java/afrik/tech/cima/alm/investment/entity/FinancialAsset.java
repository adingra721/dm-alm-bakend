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
@Table(name = "inv_actifs_financiers")
public class FinancialAsset extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String code;

    @Column(nullable = false, length = 180)
    private String libelle;

    private Long acquisitionId;
    private Long compagnieId;
    private Long filialeId;
    private Long typeActifId;
    private Long categorieActifId;
    private Long paysEmetteurId;
    private Long deviseId;

    @Column(length = 180)
    private String emetteur;

    @Column(precision = 19, scale = 4)
    private BigDecimal valeurNominale;

    @Column(precision = 19, scale = 4)
    private BigDecimal valeurAcquisition;

    @Column(precision = 10, scale = 6)
    private BigDecimal tauxCoupon;

    private LocalDate dateAcquisition;
    private LocalDate dateEcheance;

    @Column(nullable = false, length = 40)
    private String statut = "ACTIF";

    @Column(nullable = false)
    private Boolean actif = true;
}
