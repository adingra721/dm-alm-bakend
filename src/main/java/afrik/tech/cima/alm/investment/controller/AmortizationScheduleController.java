package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AmortizationScheduleDto;
import afrik.tech.cima.alm.investment.service.AmortizationScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/amortissements")
public class AmortizationScheduleController extends AbstractCrudController<AmortizationScheduleDto> {

    public AmortizationScheduleController(AmortizationScheduleService service) {
        super(service);
    }
}
