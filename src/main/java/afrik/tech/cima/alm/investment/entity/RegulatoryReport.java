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
@Table(name = "inv_etats_cima")
public class RegulatoryReport extends BaseEntity {

    @Column(nullable = false, length = 40)
    private String codeEtat;

    @Column(nullable = false, length = 180)
    private String libelle;

    private Long compagnieId;
    private LocalDate periodeDebut;
    private LocalDate periodeFin;

    @Column(nullable = false, length = 40)
    private String statut = "BROUILLON";

    @Column(length = 180)
    private String fichierGenere;

    @Column(length = 500)
    private String commentaire;
}
