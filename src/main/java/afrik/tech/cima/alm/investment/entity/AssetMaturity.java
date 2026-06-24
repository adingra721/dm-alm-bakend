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
@Table(name = "inv_tombees")
public class AssetMaturity extends BaseEntity {

    private Long actifId;

    @Column(nullable = false, length = 80)
    private String typeTombee;

    private LocalDate datePrevue;
    private LocalDate dateReception;

    @Column(precision = 19, scale = 4)
    private BigDecimal montantAttendu;

    @Column(precision = 19, scale = 4)
    private BigDecimal montantRecu;

    @Column(nullable = false, length = 40)
    private String statut = "EN_ATTENTE";

    @Column(length = 120)
    private String referencePiece;

    @Column(length = 500)
    private String commentaire;
}
