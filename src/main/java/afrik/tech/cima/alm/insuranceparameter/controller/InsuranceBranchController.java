package afrik.tech.cima.alm.insuranceparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.insuranceparameter.service.InsuranceBranchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-assurance/branches-assurance")
public class InsuranceBranchController extends AbstractCrudController<ReferenceDto> {
    public InsuranceBranchController(InsuranceBranchService service) {
        super(service);
    }
}
