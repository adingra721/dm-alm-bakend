package afrik.tech.cima.alm.organization.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.organization.dto.CurrencyDto;
import afrik.tech.cima.alm.organization.entity.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CurrencyMapper extends GenericMapper<Currency, CurrencyDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Currency toEntity(CurrencyDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(CurrencyDto dto, @MappingTarget Currency entity);
}
