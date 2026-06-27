package afrik.tech.cima.alm.security.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.security.dto.PasswordResetTokenDto;
import afrik.tech.cima.alm.security.service.PasswordResetTokenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/securite/password-reset-tokens")
public class PasswordResetTokenController extends AbstractCrudController<PasswordResetTokenDto> {

    public PasswordResetTokenController(PasswordResetTokenService service) {
        super(service);
    }
}
