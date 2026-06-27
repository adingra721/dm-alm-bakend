package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.SecurityParameterDto;
import afrik.tech.cima.alm.security.service.SecurityParameterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/parametres")
public class SecurityParameterController extends AbstractCrudController<SecurityParameterDto> {

    public SecurityParameterController(SecurityParameterService service) {
        super(service);
    }
}
