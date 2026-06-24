package afrik.tech.cima.alm.investment.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.investment.dto.RegulatoryReportDto;
import afrik.tech.cima.alm.investment.entity.RegulatoryReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RegulatoryReportMapper extends GenericMapper<RegulatoryReport, RegulatoryReportDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RegulatoryReport toEntity(RegulatoryReportDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(RegulatoryReportDto dto, @MappingTarget RegulatoryReport entity);
}
