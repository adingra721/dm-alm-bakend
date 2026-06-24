package afrik.tech.cima.alm.insuranceparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.insuranceparameter.entity.InsuranceProduct;
import afrik.tech.cima.alm.insuranceparameter.mapper.InsuranceProductMapper;
import afrik.tech.cima.alm.insuranceparameter.repository.InsuranceProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InsuranceProductService extends AbstractCrudService<InsuranceProduct, ReferenceDto> {
    public InsuranceProductService(InsuranceProductRepository repository, InsuranceProductMapper mapper) {
        super(repository, mapper, "Produit assurance");
    }
}
