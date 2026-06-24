package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.ScenarioType;
import afrik.tech.cima.alm.almreference.mapper.ScenarioTypeMapper;
import afrik.tech.cima.alm.almreference.repository.ScenarioTypeRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class ScenarioTypeService extends AbstractCrudService<ScenarioType, ReferenceDto> {
    public ScenarioTypeService(ScenarioTypeRepository repository, ScenarioTypeMapper mapper) {
        super(repository, mapper, "Type de scenario");
    }
}
