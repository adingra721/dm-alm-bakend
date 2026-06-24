package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AssetRatingDto;
import afrik.tech.cima.alm.investment.entity.AssetRating;
import afrik.tech.cima.alm.investment.mapper.AssetRatingMapper;
import afrik.tech.cima.alm.investment.repository.AssetRatingRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetRatingService extends AbstractCrudService<AssetRating, AssetRatingDto> {

    public AssetRatingService(AssetRatingRepository repository, AssetRatingMapper mapper) {
        super(repository, mapper, "Rating actif");
    }
}
