package afrik.tech.cima.alm.insuranceparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.insuranceparameter.entity.ContractType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractTypeMapper extends GenericMapper<ContractType, ReferenceDto> {
}
