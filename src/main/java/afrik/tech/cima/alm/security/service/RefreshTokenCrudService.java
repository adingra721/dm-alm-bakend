package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.RefreshTokenDto;
import afrik.tech.cima.alm.security.entity.RefreshToken;
import afrik.tech.cima.alm.security.mapper.RefreshTokenMapper;
import afrik.tech.cima.alm.security.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenCrudService extends AbstractCrudService<RefreshToken, RefreshTokenDto> {

    public RefreshTokenCrudService(RefreshTokenRepository repository, RefreshTokenMapper mapper) {
        super(repository, mapper, "Refresh token");
    }
}
