package afrik.tech.cima.alm.insuranceparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.insuranceparameter.service.ContractTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-assurance/types-contrats")
public class ContractTypeController extends AbstractCrudController<ReferenceDto> {
    public ContractTypeController(ContractTypeService service) {
        super(service);
    }
}
