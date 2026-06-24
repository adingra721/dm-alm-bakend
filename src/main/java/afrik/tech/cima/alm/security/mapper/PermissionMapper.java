package afrik.tech.cima.alm.security.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.security.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends GenericMapper<Permission, ReferenceDto> {
}
