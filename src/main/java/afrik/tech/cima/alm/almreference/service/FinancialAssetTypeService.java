package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.FinancialAssetType;
import afrik.tech.cima.alm.almreference.mapper.FinancialAssetTypeMapper;
import afrik.tech.cima.alm.almreference.repository.FinancialAssetTypeRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class FinancialAssetTypeService extends AbstractCrudService<FinancialAssetType, ReferenceDto> {
    public FinancialAssetTypeService(FinancialAssetTypeRepository repository, FinancialAssetTypeMapper mapper) {
        super(repository, mapper, "Type d'actif financier");
    }
}
