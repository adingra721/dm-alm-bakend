package afrik.tech.cima.alm.insuranceparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.insuranceparameter.entity.InsuranceBranch;
import afrik.tech.cima.alm.insuranceparameter.mapper.InsuranceBranchMapper;
import afrik.tech.cima.alm.insuranceparameter.repository.InsuranceBranchRepository;
import org.springframework.stereotype.Service;

@Service
public class InsuranceBranchService extends AbstractCrudService<InsuranceBranch, ReferenceDto> {
    public InsuranceBranchService(InsuranceBranchRepository repository, InsuranceBranchMapper mapper) {
        super(repository, mapper, "Branche assurance");
    }
}
