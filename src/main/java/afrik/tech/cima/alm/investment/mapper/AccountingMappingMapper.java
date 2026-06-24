package afrik.tech.cima.alm.investment.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.investment.dto.AccountingMappingDto;
import afrik.tech.cima.alm.investment.entity.AccountingMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountingMappingMapper extends GenericMapper<AccountingMapping, AccountingMappingDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AccountingMapping toEntity(AccountingMappingDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(AccountingMappingDto dto, @MappingTarget AccountingMapping entity);
}
