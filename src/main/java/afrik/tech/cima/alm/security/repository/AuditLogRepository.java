package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
