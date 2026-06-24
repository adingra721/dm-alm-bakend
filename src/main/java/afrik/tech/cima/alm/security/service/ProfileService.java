package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.security.entity.Profile;
import afrik.tech.cima.alm.security.mapper.ProfileMapper;
import afrik.tech.cima.alm.security.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends AbstractCrudService<Profile, ReferenceDto> {
    public ProfileService(ProfileRepository repository, ProfileMapper mapper) {
        super(repository, mapper, "Profil");
    }
}
