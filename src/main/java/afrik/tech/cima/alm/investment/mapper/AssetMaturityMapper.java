package afrik.tech.cima.alm.investment.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.investment.dto.AssetMaturityDto;
import afrik.tech.cima.alm.investment.entity.AssetMaturity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AssetMaturityMapper extends GenericMapper<AssetMaturity, AssetMaturityDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AssetMaturity toEntity(AssetMaturityDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(AssetMaturityDto dto, @MappingTarget AssetMaturity entity);
}
