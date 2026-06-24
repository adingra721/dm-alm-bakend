package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AssetRatingDto;
import afrik.tech.cima.alm.investment.service.AssetRatingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/ratings")
public class AssetRatingController extends AbstractCrudController<AssetRatingDto> {

    public AssetRatingController(AssetRatingService service) {
        super(service);
    }
}
