package afrik.tech.cima.alm.organization.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.organization.dto.SubsidiaryDto;
import afrik.tech.cima.alm.organization.service.SubsidiaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organisation/filiales")
public class SubsidiaryController extends AbstractCrudController<SubsidiaryDto> {

    public SubsidiaryController(SubsidiaryService service) {
        super(service);
    }
}
