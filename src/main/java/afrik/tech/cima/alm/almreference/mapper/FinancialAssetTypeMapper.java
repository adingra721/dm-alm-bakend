package afrik.tech.cima.alm.almreference.mapper;

import afrik.tech.cima.alm.almreference.dto.FinancialAssetTypeDto;
import afrik.tech.cima.alm.almreference.entity.FinancialAssetType;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FinancialAssetTypeMapper extends GenericMapper<FinancialAssetType, FinancialAssetTypeDto> {

    @Override
    @Mapping(target = "categorieActifId", source = "categorieActif.id")
    @Mapping(target = "categorieActifLibelle", source = "categorieActif.libelle")
    FinancialAssetTypeDto toDto(FinancialAssetType entity);

    @Override
    @Mapping(target = "categorieActif", ignore = true)
    FinancialAssetType toEntity(FinancialAssetTypeDto dto);

    @Override
    @Mapping(target = "categorieActif", ignore = true)
    void updateEntity(FinancialAssetTypeDto dto, @MappingTarget FinancialAssetType entity);
}
