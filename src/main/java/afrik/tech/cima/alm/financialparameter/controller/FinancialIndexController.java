package afrik.tech.cima.alm.financialparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.financialparameter.service.FinancialIndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-financiers/indices-financiers")
public class FinancialIndexController extends AbstractCrudController<ReferenceDto> {
    public FinancialIndexController(FinancialIndexService service) {
        super(service);
    }
}
