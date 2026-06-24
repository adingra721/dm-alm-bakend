package afrik.tech.cima.alm.almreference.controller;

import afrik.tech.cima.alm.almreference.service.LiabilityTypeService;
import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/referentiels-alm/types-passifs")
public class LiabilityTypeController extends AbstractCrudController<ReferenceDto> {
    public LiabilityTypeController(LiabilityTypeService service) {
        super(service);
    }
}
