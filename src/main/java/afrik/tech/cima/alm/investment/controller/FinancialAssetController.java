package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.FinancialAssetDto;
import afrik.tech.cima.alm.investment.service.FinancialAssetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/actifs")
public class FinancialAssetController extends AbstractCrudController<FinancialAssetDto> {

    public FinancialAssetController(FinancialAssetService service) {
        super(service);
    }
}
