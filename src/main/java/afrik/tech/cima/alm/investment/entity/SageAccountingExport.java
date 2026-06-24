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
@Table(name = "inv_exports_sage")
public class SageAccountingExport extends BaseEntity {

    @Column(nullable = false, unique = true, length = 80)
    private String referenceExport;

    private Long compagnieId;
    private LocalDate periodeDebut;
    private LocalDate periodeFin;

    @Column(nullable = false, length = 40)
    private String formatCible = "SAGE_100";

    @Column(nullable = false, length = 40)
    private String modeExport = "PAR_OPERATION";

    @Column(nullable = false, length = 40)
    private String statut = "PREPARE";

    private Integer nombreEcritures;

    @Column(precision = 19, scale = 4)
    private BigDecimal montantTotal;

    @Column(length = 180)
    private String fichierGenere;

    @Column(length = 500)
    private String messageErreur;
}
