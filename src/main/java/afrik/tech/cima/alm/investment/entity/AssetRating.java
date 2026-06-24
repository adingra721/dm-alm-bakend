package afrik.tech.cima.alm.investment.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inv_ratings_actifs")
public class AssetRating extends BaseEntity {

    private Long actifId;

    @Column(nullable = false, length = 80)
    private String agence;

    @Column(length = 40)
    private String noteEmetteur;

    @Column(length = 40)
    private String notePays;

    private LocalDate dateNotation;

    @Column(length = 80)
    private String perspective;

    @Column(length = 500)
    private String commentaire;
}
