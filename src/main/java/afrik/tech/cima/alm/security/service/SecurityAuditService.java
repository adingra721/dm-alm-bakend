package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.security.entity.AppUser;
import afrik.tech.cima.alm.security.entity.AuditLog;
import afrik.tech.cima.alm.security.repository.AuditLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class SecurityAuditService {

    private final AuditLogRepository repository;

    public SecurityAuditService(AuditLogRepository repository) {
        this.repository = repository;
    }

    public void log(AppUser user, String action, String resourceType, String resourceId, String details, HttpServletRequest request) {
        AuditLog log = new AuditLog();
        if (user != null) {
            log.setUserId(user.getId());
            log.setUsername(user.getUsername());
        }
        log.setAction(action);
        log.setResourceType(resourceType);
        log.setResourceId(resourceId);
        log.setDetails(details);
        if (request != null) {
            log.setIpAddress(request.getRemoteAddr());
            log.setUserAgent(request.getHeader("User-Agent"));
        }
        repository.save(log);
    }
}
