package afrik.tech.cima.alm.security.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.security.dto.RefreshTokenDto;
import afrik.tech.cima.alm.security.entity.RefreshToken;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper extends GenericMapper<RefreshToken, RefreshTokenDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RefreshToken toEntity(RefreshTokenDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(RefreshTokenDto dto, @MappingTarget RefreshToken entity);
}
