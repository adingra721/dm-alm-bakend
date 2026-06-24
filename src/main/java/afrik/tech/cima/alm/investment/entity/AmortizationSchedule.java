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
@Table(name = "inv_tableaux_amortissement")
public class AmortizationSchedule extends BaseEntity {

    private Long actifId;
    private Integer numeroEcheance;
    private LocalDate dateEcheance;

    @Column(precision = 19, scale = 4)
    private BigDecimal capitalDebut;

    @Column(precision = 19, scale = 4)
    private BigDecimal interet;

    @Column(precision = 19, scale = 4)
    private BigDecimal amortissement;

    @Column(precision = 19, scale = 4)
    private BigDecimal capitalFin;

    @Column(nullable = false, length = 40)
    private String statut = "PREVU";
}
