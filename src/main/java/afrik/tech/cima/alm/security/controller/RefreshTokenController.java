package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.RefreshTokenDto;
import afrik.tech.cima.alm.security.service.RefreshTokenCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/refresh-tokens")
public class RefreshTokenController extends AbstractCrudController<RefreshTokenDto> {

    public RefreshTokenController(RefreshTokenCrudService service) {
        super(service);
    }
}
