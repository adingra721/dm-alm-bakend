package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.dto.FinancialAssetTypeDto;
import afrik.tech.cima.alm.almreference.entity.AssetCategory;
import afrik.tech.cima.alm.almreference.entity.FinancialAssetType;
import afrik.tech.cima.alm.almreference.mapper.FinancialAssetTypeMapper;
import afrik.tech.cima.alm.almreference.repository.AssetCategoryRepository;
import afrik.tech.cima.alm.almreference.repository.FinancialAssetTypeRepository;
import afrik.tech.cima.alm.common.exception.BadRequestException;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinancialAssetTypeService extends AbstractCrudService<FinancialAssetType, FinancialAssetTypeDto> {

    private final FinancialAssetTypeRepository repository;
    private final AssetCategoryRepository assetCategoryRepository;
    private final FinancialAssetTypeMapper mapper;

    public FinancialAssetTypeService(FinancialAssetTypeRepository repository, AssetCategoryRepository assetCategoryRepository,
                                     FinancialAssetTypeMapper mapper) {
        super(repository, mapper, "Type d'actif financier");
        this.repository = repository;
        this.assetCategoryRepository = assetCategoryRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public FinancialAssetTypeDto create(FinancialAssetTypeDto dto) {
        FinancialAssetType entity = mapper.toEntity(dto);
        entity.setId(null);
        entity.setCategorieActif(resolveCategory(dto.categorieActifId()));
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional
    public FinancialAssetTypeDto update(Long id, FinancialAssetTypeDto dto) {
        FinancialAssetType entity = findEntity(id);
        mapper.updateEntity(dto, entity);
        entity.setCategorieActif(resolveCategory(dto.categorieActifId()));
        return mapper.toDto(repository.save(entity));
    }

    private AssetCategory resolveCategory(Long categorieActifId) {
        if (categorieActifId == null) {
            return null;
        }
        return assetCategoryRepository.findById(categorieActifId)
                .orElseThrow(() -> new BadRequestException("Categorie d'actif introuvable avec id=" + categorieActifId));
    }
}
