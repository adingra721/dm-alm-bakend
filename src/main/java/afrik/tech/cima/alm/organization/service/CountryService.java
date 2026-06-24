package afrik.tech.cima.alm.organization.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.organization.dto.CountryDto;
import afrik.tech.cima.alm.organization.entity.Country;
import afrik.tech.cima.alm.organization.mapper.CountryMapper;
import afrik.tech.cima.alm.organization.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractCrudService<Country, CountryDto> {

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper, "Pays");
    }
}
