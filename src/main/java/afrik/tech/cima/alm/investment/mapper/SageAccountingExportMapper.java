package afrik.tech.cima.alm.investment.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.investment.dto.SageAccountingExportDto;
import afrik.tech.cima.alm.investment.entity.SageAccountingExport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SageAccountingExportMapper extends GenericMapper<SageAccountingExport, SageAccountingExportDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SageAccountingExport toEntity(SageAccountingExportDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(SageAccountingExportDto dto, @MappingTarget SageAccountingExport entity);
}
