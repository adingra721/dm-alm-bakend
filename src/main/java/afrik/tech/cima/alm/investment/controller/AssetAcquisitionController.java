package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AssetAcquisitionDto;
import afrik.tech.cima.alm.investment.service.AssetAcquisitionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/acquisitions")
public class AssetAcquisitionController extends AbstractCrudController<AssetAcquisitionDto> {

    public AssetAcquisitionController(AssetAcquisitionService service) {
        super(service);
    }
}
