package afrik.tech.cima.alm.investment.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.investment.dto.AssetDocumentDto;
import afrik.tech.cima.alm.investment.entity.AssetDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AssetDocumentMapper extends GenericMapper<AssetDocument, AssetDocumentDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AssetDocument toEntity(AssetDocumentDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(AssetDocumentDto dto, @MappingTarget AssetDocument entity);
}
