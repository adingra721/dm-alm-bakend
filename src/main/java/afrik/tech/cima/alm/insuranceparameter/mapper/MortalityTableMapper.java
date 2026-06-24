package afrik.tech.cima.alm.insuranceparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.insuranceparameter.entity.MortalityTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MortalityTableMapper extends GenericMapper<MortalityTable, ReferenceDto> {
}
