package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.UserSessionDto;
import afrik.tech.cima.alm.security.entity.UserSession;
import afrik.tech.cima.alm.security.mapper.UserSessionMapper;
import afrik.tech.cima.alm.security.repository.UserSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService extends AbstractCrudService<UserSession, UserSessionDto> {

    public UserSessionService(UserSessionRepository repository, UserSessionMapper mapper) {
        super(repository, mapper, "Session utilisateur");
    }
}
