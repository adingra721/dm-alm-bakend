package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.AuditLogDto;
import afrik.tech.cima.alm.security.entity.AuditLog;
import afrik.tech.cima.alm.security.mapper.AuditLogMapper;
import afrik.tech.cima.alm.security.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService extends AbstractCrudService<AuditLog, AuditLogDto> {

    public AuditLogService(AuditLogRepository repository, AuditLogMapper mapper) {
        super(repository, mapper, "Journal d'audit");
    }
}
