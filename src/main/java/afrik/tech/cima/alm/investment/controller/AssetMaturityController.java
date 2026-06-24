package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AssetMaturityDto;
import afrik.tech.cima.alm.investment.service.AssetMaturityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/tombees")
public class AssetMaturityController extends AbstractCrudController<AssetMaturityDto> {

    public AssetMaturityController(AssetMaturityService service) {
        super(service);
    }
}
