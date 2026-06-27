package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.AuditLogDto;
import afrik.tech.cima.alm.security.service.AuditLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/audit")
public class AuditLogController extends AbstractCrudController<AuditLogDto> {

    public AuditLogController(AuditLogService service) {
        super(service);
    }
}
