package afrik.tech.cima.alm.organization.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.organization.dto.CompanyDto;
import afrik.tech.cima.alm.organization.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organisation/compagnies")
public class CompanyController extends AbstractCrudController<CompanyDto> {

    public CompanyController(CompanyService service) {
        super(service);
    }
}
