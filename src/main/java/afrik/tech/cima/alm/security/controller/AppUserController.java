package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.AppUserDto;
import afrik.tech.cima.alm.security.service.AppUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/utilisateurs")
public class AppUserController extends AbstractCrudController<AppUserDto> {
    public AppUserController(AppUserService service) {
        super(service);
    }
}
