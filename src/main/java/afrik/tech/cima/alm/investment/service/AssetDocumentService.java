package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AssetDocumentDto;
import afrik.tech.cima.alm.investment.entity.AssetDocument;
import afrik.tech.cima.alm.investment.mapper.AssetDocumentMapper;
import afrik.tech.cima.alm.investment.repository.AssetDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetDocumentService extends AbstractCrudService<AssetDocument, AssetDocumentDto> {

    public AssetDocumentService(AssetDocumentRepository repository, AssetDocumentMapper mapper) {
        super(repository, mapper, "Document actif");
    }
}
