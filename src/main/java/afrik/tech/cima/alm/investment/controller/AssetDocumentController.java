package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AssetDocumentDto;
import afrik.tech.cima.alm.investment.service.AssetDocumentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/documents")
public class AssetDocumentController extends AbstractCrudController<AssetDocumentDto> {

    public AssetDocumentController(AssetDocumentService service) {
        super(service);
    }
}
