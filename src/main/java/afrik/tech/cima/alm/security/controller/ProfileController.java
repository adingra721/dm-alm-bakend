package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.security.service.ProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/profils")
public class ProfileController extends AbstractCrudController<ReferenceDto> {
    public ProfileController(ProfileService service) {
        super(service);
    }
}
