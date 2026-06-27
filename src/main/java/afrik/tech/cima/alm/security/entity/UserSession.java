package afrik.tech.cima.alm.security.entity;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "sec_sessions")
public class UserSession extends BaseEntity {

    private Long userId;

    @Column(nullable = false, unique = true, length = 120)
    private String sessionToken;

    @Column(length = 80)
    private String ipAddress;

    @Column(length = 500)
    private String userAgent;

    private OffsetDateTime expiresAt;
    private OffsetDateTime revokedAt;

    @Column(nullable = false)
    private Boolean active = true;
}
