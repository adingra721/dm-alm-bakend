package afrik.tech.cima.alm.security.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sec_parametres")
public class SecurityParameter extends BaseEntity {

    @Column(nullable = false, unique = true, length = 120)
    private String code;

    @Column(nullable = false, length = 180)
    private String libelle;

    @Column(nullable = false, length = 500)
    private String valeur;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean actif = true;
}
