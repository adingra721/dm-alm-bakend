package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.RegulatoryReportDto;
import afrik.tech.cima.alm.investment.service.RegulatoryReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/etats-cima")
public class RegulatoryReportController extends AbstractCrudController<RegulatoryReportDto> {

    public RegulatoryReportController(RegulatoryReportService service) {
        super(service);
    }
}
