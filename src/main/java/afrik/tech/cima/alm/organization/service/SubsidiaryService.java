package afrik.tech.cima.alm.organization.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.organization.dto.SubsidiaryDto;
import afrik.tech.cima.alm.organization.entity.Subsidiary;
import afrik.tech.cima.alm.organization.mapper.SubsidiaryMapper;
import afrik.tech.cima.alm.organization.repository.SubsidiaryRepository;
import org.springframework.stereotype.Service;

@Service
public class SubsidiaryService extends AbstractCrudService<Subsidiary, SubsidiaryDto> {

    public SubsidiaryService(SubsidiaryRepository repository, SubsidiaryMapper mapper) {
        super(repository, mapper, "Filiale");
    }
}
