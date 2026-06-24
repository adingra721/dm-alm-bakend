package afrik.tech.cima.alm.security.entity;

import afrik.tech.cima.alm.common.entity.ReferenceEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sec_permissions")
public class Permission extends ReferenceEntity {
}
