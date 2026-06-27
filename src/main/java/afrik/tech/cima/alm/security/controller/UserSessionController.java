package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.UserSessionDto;
import afrik.tech.cima.alm.security.service.UserSessionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/sessions")
public class UserSessionController extends AbstractCrudController<UserSessionDto> {

    public UserSessionController(UserSessionService service) {
        super(service);
    }
}
