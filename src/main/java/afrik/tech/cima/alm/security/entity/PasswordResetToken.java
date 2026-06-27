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
@Table(name = "sec_password_reset_tokens")
public class PasswordResetToken extends BaseEntity {

    private Long userId;

    @Column(nullable = false, unique = true, length = 160)
    private String tokenHash;

    private OffsetDateTime expiresAt;
    private OffsetDateTime usedAt;
}
