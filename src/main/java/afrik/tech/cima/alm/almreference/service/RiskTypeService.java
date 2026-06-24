package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.RiskType;
import afrik.tech.cima.alm.almreference.mapper.RiskTypeMapper;
import afrik.tech.cima.alm.almreference.repository.RiskTypeRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class RiskTypeService extends AbstractCrudService<RiskType, ReferenceDto> {
    public RiskTypeService(RiskTypeRepository repository, RiskTypeMapper mapper) {
        super(repository, mapper, "Type de risque");
    }
}
