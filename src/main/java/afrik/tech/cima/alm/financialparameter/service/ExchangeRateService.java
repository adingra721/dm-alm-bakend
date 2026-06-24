package afrik.tech.cima.alm.financialparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.financialparameter.entity.ExchangeRate;
import afrik.tech.cima.alm.financialparameter.mapper.ExchangeRateMapper;
import afrik.tech.cima.alm.financialparameter.repository.ExchangeRateRepository;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService extends AbstractCrudService<ExchangeRate, ReferenceDto> {
    public ExchangeRateService(ExchangeRateRepository repository, ExchangeRateMapper mapper) {
        super(repository, mapper, "Taux de change");
    }
}
