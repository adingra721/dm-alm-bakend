package afrik.tech.cima.alm.security.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.security.dto.PasswordResetTokenDto;
import afrik.tech.cima.alm.security.entity.PasswordResetToken;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PasswordResetTokenMapper extends GenericMapper<PasswordResetToken, PasswordResetTokenDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PasswordResetToken toEntity(PasswordResetTokenDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(PasswordResetTokenDto dto, @MappingTarget PasswordResetToken entity);
}
