package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.SageAccountingExportDto;
import afrik.tech.cima.alm.investment.entity.SageAccountingExport;
import afrik.tech.cima.alm.investment.mapper.SageAccountingExportMapper;
import afrik.tech.cima.alm.investment.repository.SageAccountingExportRepository;
import org.springframework.stereotype.Service;

@Service
public class SageAccountingExportService extends AbstractCrudService<SageAccountingExport, SageAccountingExportDto> {

    public SageAccountingExportService(SageAccountingExportRepository repository, SageAccountingExportMapper mapper) {
        super(repository, mapper, "Export SAGE");
    }
}
