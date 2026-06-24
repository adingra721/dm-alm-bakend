package afrik.tech.cima.alm.insuranceparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.insuranceparameter.service.MortalityTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-assurance/tables-mortalite")
public class MortalityTableController extends AbstractCrudController<ReferenceDto> {
    public MortalityTableController(MortalityTableService service) {
        super(service);
    }
}
