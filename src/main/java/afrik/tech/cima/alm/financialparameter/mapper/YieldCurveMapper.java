package afrik.tech.cima.alm.financialparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.financialparameter.entity.YieldCurve;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YieldCurveMapper extends GenericMapper<YieldCurve, ReferenceDto> {
}
