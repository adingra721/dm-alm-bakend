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
@Table(name = "org_devises")
public class Currency extends ReferenceEntity {

    @Column(nullable = false, length = 3)
    private String codeIso;

    @Column(length = 10)
    private String symbole;
}
