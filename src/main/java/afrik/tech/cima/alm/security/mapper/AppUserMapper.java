package afrik.tech.cima.alm.security.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.security.dto.AppUserDto;
import afrik.tech.cima.alm.security.entity.AppUser;
import afrik.tech.cima.alm.security.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AppUserMapper extends GenericMapper<AppUser, AppUserDto> {

    @Override
    @Mapping(source = "profil.id", target = "profilId")
    AppUserDto toDto(AppUser entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "profilId", target = "profil")
    AppUser toEntity(AppUserDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "profilId", target = "profil")
    void updateEntity(AppUserDto dto, @MappingTarget AppUser entity);

    default Profile mapProfile(Long id) {
        if (id == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setId(id);
        return profile;
    }
}
