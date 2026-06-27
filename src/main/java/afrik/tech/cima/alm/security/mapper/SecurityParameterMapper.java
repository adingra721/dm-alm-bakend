package afrik.tech.cima.alm.security.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.security.dto.SecurityParameterDto;
import afrik.tech.cima.alm.security.entity.SecurityParameter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SecurityParameterMapper extends GenericMapper<SecurityParameter, SecurityParameterDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SecurityParameter toEntity(SecurityParameterDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(SecurityParameterDto dto, @MappingTarget SecurityParameter entity);
}
