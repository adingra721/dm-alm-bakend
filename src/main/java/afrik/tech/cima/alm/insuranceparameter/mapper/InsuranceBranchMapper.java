package afrik.tech.cima.alm.insuranceparameter.mapper;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.insuranceparameter.entity.InsuranceBranch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceBranchMapper extends GenericMapper<InsuranceBranch, ReferenceDto> {
}
