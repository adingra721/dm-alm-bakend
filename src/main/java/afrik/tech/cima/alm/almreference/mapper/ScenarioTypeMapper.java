package afrik.tech.cima.alm.almreference.mapper;

import afrik.tech.cima.alm.almreference.entity.ScenarioType;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScenarioTypeMapper extends GenericMapper<ScenarioType, ReferenceDto> {
}
