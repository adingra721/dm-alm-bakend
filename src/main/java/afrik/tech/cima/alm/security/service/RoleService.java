package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.entity.Role;
import afrik.tech.cima.alm.security.mapper.RoleMapper;
import afrik.tech.cima.alm.security.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractCrudService<Role, ReferenceDto> {
    public RoleService(RoleRepository repository, RoleMapper mapper) {
        super(repository, mapper, "Role");
    }
}
