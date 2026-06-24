package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.FinancialAssetDto;
import afrik.tech.cima.alm.investment.entity.FinancialAsset;
import afrik.tech.cima.alm.investment.mapper.FinancialAssetMapper;
import afrik.tech.cima.alm.investment.repository.FinancialAssetRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialAssetService extends AbstractCrudService<FinancialAsset, FinancialAssetDto> {

    public FinancialAssetService(FinancialAssetRepository repository, FinancialAssetMapper mapper) {
        super(repository, mapper, "Actif financier");
    }
}
