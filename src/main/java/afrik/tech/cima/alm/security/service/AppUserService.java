package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.dto.AppUserDto;
import afrik.tech.cima.alm.security.entity.AppUser;
import afrik.tech.cima.alm.security.mapper.AppUserMapper;
import afrik.tech.cima.alm.security.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService extends AbstractCrudService<AppUser, AppUserDto> {
    public AppUserService(AppUserRepository repository, AppUserMapper mapper) {
        super(repository, mapper, "Utilisateur");
    }
}
