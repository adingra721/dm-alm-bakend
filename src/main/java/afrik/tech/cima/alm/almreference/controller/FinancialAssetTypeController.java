package afrik.tech.cima.alm.almreference.controller;

import afrik.tech.cima.alm.almreference.service.FinancialAssetTypeService;
import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/referentiels-alm/types-actifs-financiers")
public class FinancialAssetTypeController extends AbstractCrudController<ReferenceDto> {
    public FinancialAssetTypeController(FinancialAssetTypeService service) {
        super(service);
    }
}
