package afrik.tech.cima.alm.organization.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.organization.dto.CurrencyDto;
import afrik.tech.cima.alm.organization.service.CurrencyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organisation/devises")
public class CurrencyController extends AbstractCrudController<CurrencyDto> {

    public CurrencyController(CurrencyService service) {
        super(service);
    }
}
