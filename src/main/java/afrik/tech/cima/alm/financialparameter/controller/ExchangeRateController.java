package afrik.tech.cima.alm.financialparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.financialparameter.service.ExchangeRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-financiers/taux-change")
public class ExchangeRateController extends AbstractCrudController<ReferenceDto> {
    public ExchangeRateController(ExchangeRateService service) {
        super(service);
    }
}
