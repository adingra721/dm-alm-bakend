package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.LiabilityType;
import afrik.tech.cima.alm.almreference.mapper.LiabilityTypeMapper;
import afrik.tech.cima.alm.almreference.repository.LiabilityTypeRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class LiabilityTypeService extends AbstractCrudService<LiabilityType, ReferenceDto> {
    public LiabilityTypeService(LiabilityTypeRepository repository, LiabilityTypeMapper mapper) {
        super(repository, mapper, "Type de passif");
    }
}
