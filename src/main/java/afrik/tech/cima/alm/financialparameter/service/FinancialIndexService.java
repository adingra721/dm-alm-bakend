package afrik.tech.cima.alm.financialparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.financialparameter.entity.FinancialIndex;
import afrik.tech.cima.alm.financialparameter.mapper.FinancialIndexMapper;
import afrik.tech.cima.alm.financialparameter.repository.FinancialIndexRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialIndexService extends AbstractCrudService<FinancialIndex, ReferenceDto> {
    public FinancialIndexService(FinancialIndexRepository repository, FinancialIndexMapper mapper) {
        super(repository, mapper, "Indice financier");
    }
}
