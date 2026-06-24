package afrik.tech.cima.alm.insuranceparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.insuranceparameter.entity.ProvisionType;
import afrik.tech.cima.alm.insuranceparameter.mapper.ProvisionTypeMapper;
import afrik.tech.cima.alm.insuranceparameter.repository.ProvisionTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvisionTypeService extends AbstractCrudService<ProvisionType, ReferenceDto> {
    public ProvisionTypeService(ProvisionTypeRepository repository, ProvisionTypeMapper mapper) {
        super(repository, mapper, "Type de provision");
    }
}
