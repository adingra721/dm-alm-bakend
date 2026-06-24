package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.PortfolioType;
import afrik.tech.cima.alm.almreference.mapper.PortfolioTypeMapper;
import afrik.tech.cima.alm.almreference.repository.PortfolioTypeRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class PortfolioTypeService extends AbstractCrudService<PortfolioType, ReferenceDto> {
    public PortfolioTypeService(PortfolioTypeRepository repository, PortfolioTypeMapper mapper) {
        super(repository, mapper, "Type de portefeuille");
    }
}
