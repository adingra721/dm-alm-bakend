package afrik.tech.cima.alm.organization.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.organization.dto.CompanyDto;
import afrik.tech.cima.alm.organization.entity.Company;
import afrik.tech.cima.alm.organization.mapper.CompanyMapper;
import afrik.tech.cima.alm.organization.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractCrudService<Company, CompanyDto> {

    public CompanyService(CompanyRepository repository, CompanyMapper mapper) {
        super(repository, mapper, "Compagnie");
    }
}
