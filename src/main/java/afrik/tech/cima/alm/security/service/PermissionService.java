package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.entity.Permission;
import afrik.tech.cima.alm.security.mapper.PermissionMapper;
import afrik.tech.cima.alm.security.repository.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService extends AbstractCrudService<Permission, ReferenceDto> {
    public PermissionService(PermissionRepository repository, PermissionMapper mapper) {
        super(repository, mapper, "Permission");
    }
}
