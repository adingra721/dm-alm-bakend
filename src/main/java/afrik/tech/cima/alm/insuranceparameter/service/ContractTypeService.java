package afrik.tech.cima.alm.insuranceparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.insuranceparameter.entity.ContractType;
import afrik.tech.cima.alm.insuranceparameter.mapper.ContractTypeMapper;
import afrik.tech.cima.alm.insuranceparameter.repository.ContractTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ContractTypeService extends AbstractCrudService<ContractType, ReferenceDto> {
    public ContractTypeService(ContractTypeRepository repository, ContractTypeMapper mapper) {
        super(repository, mapper, "Type de contrat");
    }
}
