package afrik.tech.cima.alm.security.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import afrik.tech.cima.alm.organization.entity.Subsidiary;
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
@Table(name = "sec_utilisateurs")
public class AppUser extends BaseEntity {

    @Column(nullable = false, unique = true, length = 80)
    private String username;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 150)
    private String nomComplet;

    @Column(length = 255)
    private String passwordHash;

    @Column(nullable = true)
    private Boolean passwordChangeRequired = false;

    @Column(nullable = true)
    private Integer failedLoginAttempts = 0;

    private java.time.OffsetDateTime lockedUntil;

    private java.time.OffsetDateTime lastLoginAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profil;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subsidiary filiale;

    @Column(nullable = false)
    private Boolean actif = true;
}
