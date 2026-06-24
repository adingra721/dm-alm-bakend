package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AssetMaturityDto;
import afrik.tech.cima.alm.investment.entity.AssetMaturity;
import afrik.tech.cima.alm.investment.mapper.AssetMaturityMapper;
import afrik.tech.cima.alm.investment.repository.AssetMaturityRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetMaturityService extends AbstractCrudService<AssetMaturity, AssetMaturityDto> {

    public AssetMaturityService(AssetMaturityRepository repository, AssetMaturityMapper mapper) {
        super(repository, mapper, "Tombee");
    }
}
