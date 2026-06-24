package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AssetAcquisitionDto;
import afrik.tech.cima.alm.investment.entity.AssetAcquisition;
import afrik.tech.cima.alm.investment.mapper.AssetAcquisitionMapper;
import afrik.tech.cima.alm.investment.repository.AssetAcquisitionRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetAcquisitionService extends AbstractCrudService<AssetAcquisition, AssetAcquisitionDto> {

    public AssetAcquisitionService(AssetAcquisitionRepository repository, AssetAcquisitionMapper mapper) {
        super(repository, mapper, "Dossier d'acquisition");
    }
}
