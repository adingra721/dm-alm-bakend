package afrik.tech.cima.alm.organization.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "org_compagnies")
public class Company extends BaseEntity {

    @Column(nullable = false, unique = true, length = 60)
    private String code;

    @Column(nullable = false, length = 150)
    private String raisonSociale;

    @Column(length = 80)
    private String numeroAgrement;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country pays;

    @ManyToOne(fetch = FetchType.LAZY)
    private Currency deviseFonctionnelle;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address adresseSiege;

    @Column(nullable = false)
    private Boolean actif = true;
}
