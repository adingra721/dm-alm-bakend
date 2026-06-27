package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.PasswordResetTokenDto;
import afrik.tech.cima.alm.security.entity.PasswordResetToken;
import afrik.tech.cima.alm.security.mapper.PasswordResetTokenMapper;
import afrik.tech.cima.alm.security.repository.PasswordResetTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenService extends AbstractCrudService<PasswordResetToken, PasswordResetTokenDto> {

    public PasswordResetTokenService(PasswordResetTokenRepository repository, PasswordResetTokenMapper mapper) {
        super(repository, mapper, "Token reset password");
    }
}
