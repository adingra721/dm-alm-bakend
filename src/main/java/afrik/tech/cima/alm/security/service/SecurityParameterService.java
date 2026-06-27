package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.SecurityParameterDto;
import afrik.tech.cima.alm.security.entity.SecurityParameter;
import afrik.tech.cima.alm.security.mapper.SecurityParameterMapper;
import afrik.tech.cima.alm.security.repository.SecurityParameterRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityParameterService extends AbstractCrudService<SecurityParameter, SecurityParameterDto> {

    public SecurityParameterService(SecurityParameterRepository repository, SecurityParameterMapper mapper) {
        super(repository, mapper, "Parametre securite");
    }
}
