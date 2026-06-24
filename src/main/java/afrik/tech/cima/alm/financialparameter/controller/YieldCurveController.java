package afrik.tech.cima.alm.financialparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.financialparameter.service.YieldCurveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-financiers/courbes-taux")
public class YieldCurveController extends AbstractCrudController<ReferenceDto> {
    public YieldCurveController(YieldCurveService service) {
        super(service);
    }
}
