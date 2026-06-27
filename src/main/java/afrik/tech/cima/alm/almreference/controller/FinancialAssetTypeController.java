package afrik.tech.cima.alm.almreference.controller;

import afrik.tech.cima.alm.almreference.dto.FinancialAssetTypeDto;
import afrik.tech.cima.alm.almreference.service.FinancialAssetTypeService;
import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/referentiels-alm/types-actifs-financiers")
public class FinancialAssetTypeController extends AbstractCrudController<FinancialAssetTypeDto> {
    public FinancialAssetTypeController(FinancialAssetTypeService service) {
        super(service);
    }
}
