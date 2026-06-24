package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AccountingMappingDto;
import afrik.tech.cima.alm.investment.entity.AccountingMapping;
import afrik.tech.cima.alm.investment.mapper.AccountingMappingMapper;
import afrik.tech.cima.alm.investment.repository.AccountingMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountingMappingService extends AbstractCrudService<AccountingMapping, AccountingMappingDto> {

    public AccountingMappingService(AccountingMappingRepository repository, AccountingMappingMapper mapper) {
        super(repository, mapper, "Mapping comptable");
    }
}
