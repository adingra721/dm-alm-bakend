package afrik.tech.cima.alm.financialparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.financialparameter.entity.ProjectionHorizon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectionHorizonMapper extends GenericMapper<ProjectionHorizon, ReferenceDto> {
}
