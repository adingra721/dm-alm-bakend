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
@Table(name = "sec_audit_logs")
public class AuditLog extends BaseEntity {

    private Long userId;

    @Column(length = 80)
    private String username;

    @Column(nullable = false, length = 80)
    private String action;

    @Column(length = 120)
    private String resourceType;

    @Column(length = 80)
    private String resourceId;

    @Column(length = 80)
    private String ipAddress;

    @Column(length = 500)
    private String userAgent;

    @Column(length = 1000)
    private String details;
}
