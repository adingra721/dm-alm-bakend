package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.RegulatoryReportDto;
import afrik.tech.cima.alm.investment.entity.RegulatoryReport;
import afrik.tech.cima.alm.investment.mapper.RegulatoryReportMapper;
import afrik.tech.cima.alm.investment.repository.RegulatoryReportRepository;
import org.springframework.stereotype.Service;

@Service
public class RegulatoryReportService extends AbstractCrudService<RegulatoryReport, RegulatoryReportDto> {

    public RegulatoryReportService(RegulatoryReportRepository repository, RegulatoryReportMapper mapper) {
        super(repository, mapper, "Etat CIMA");
    }
}
