package afrik.tech.cima.alm.insuranceparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.insuranceparameter.service.ProvisionTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-assurance/types-provisions")
public class ProvisionTypeController extends AbstractCrudController<ReferenceDto> {
    public ProvisionTypeController(ProvisionTypeService service) {
        super(service);
    }
}
