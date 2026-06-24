package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.SageAccountingExportDto;
import afrik.tech.cima.alm.investment.service.SageAccountingExportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/exports-sage")
public class SageAccountingExportController extends AbstractCrudController<SageAccountingExportDto> {

    public SageAccountingExportController(SageAccountingExportService service) {
        super(service);
    }
}
