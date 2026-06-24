package afrik.tech.cima.alm.organization.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.organization.dto.CountryDto;
import afrik.tech.cima.alm.organization.service.CountryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organisation/pays")
public class CountryController extends AbstractCrudController<CountryDto> {

    public CountryController(CountryService service) {
        super(service);
    }
}
