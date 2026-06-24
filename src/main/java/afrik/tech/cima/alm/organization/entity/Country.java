package afrik.tech.cima.alm.organization.entity;

import afrik.tech.cima.alm.common.entity.ReferenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "org_pays")
public class Country extends ReferenceEntity {

    @Column(length = 3)
    private String codeIso3;

    @Column(length = 20)
    private String zoneCima;
}
