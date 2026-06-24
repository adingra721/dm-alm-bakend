package afrik.tech.cima.alm.almreference.service;

import afrik.tech.cima.alm.almreference.entity.AssetCategory;
import afrik.tech.cima.alm.almreference.mapper.AssetCategoryMapper;
import afrik.tech.cima.alm.almreference.repository.AssetCategoryRepository;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class AssetCategoryService extends AbstractCrudService<AssetCategory, ReferenceDto> {
    public AssetCategoryService(AssetCategoryRepository repository, AssetCategoryMapper mapper) {
        super(repository, mapper, "Categorie d'actif");
    }
}
