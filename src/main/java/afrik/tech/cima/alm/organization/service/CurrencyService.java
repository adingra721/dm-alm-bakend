package afrik.tech.cima.alm.organization.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.organization.dto.CurrencyDto;
import afrik.tech.cima.alm.organization.entity.Currency;
import afrik.tech.cima.alm.organization.mapper.CurrencyMapper;
import afrik.tech.cima.alm.organization.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService extends AbstractCrudService<Currency, CurrencyDto> {

    public CurrencyService(CurrencyRepository repository, CurrencyMapper mapper) {
        super(repository, mapper, "Devise");
    }
}
