package afrik.tech.cima.alm.financialparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.financialparameter.entity.ProjectionHorizon;
import afrik.tech.cima.alm.financialparameter.mapper.ProjectionHorizonMapper;
import afrik.tech.cima.alm.financialparameter.repository.ProjectionHorizonRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectionHorizonService extends AbstractCrudService<ProjectionHorizon, ReferenceDto> {
    public ProjectionHorizonService(ProjectionHorizonRepository repository, ProjectionHorizonMapper mapper) {
        super(repository, mapper, "Horizon de projection");
    }
}
