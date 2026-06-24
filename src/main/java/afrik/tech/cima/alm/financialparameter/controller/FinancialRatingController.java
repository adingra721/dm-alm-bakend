package afrik.tech.cima.alm.financialparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.financialparameter.service.FinancialRatingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-financiers/notations-financieres")
public class FinancialRatingController extends AbstractCrudController<ReferenceDto> {
    public FinancialRatingController(FinancialRatingService service) {
        super(service);
    }
}
