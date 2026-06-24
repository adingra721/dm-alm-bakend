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
@Table(name = "org_adresses")
public class Address extends BaseEntity {

    @Column(length = 150)
    private String ligne1;

    @Column(length = 150)
    private String ligne2;

    @Column(length = 100)
    private String ville;

    @Column(length = 30)
    private String codePostal;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country pays;
}
