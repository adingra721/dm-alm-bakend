package afrik.tech.cima.alm.insuranceparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.insuranceparameter.entity.ProvisionType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProvisionTypeMapper extends GenericMapper<ProvisionType, ReferenceDto> {
}
