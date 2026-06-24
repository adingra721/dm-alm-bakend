package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AmortizationScheduleDto;
import afrik.tech.cima.alm.investment.entity.AmortizationSchedule;
import afrik.tech.cima.alm.investment.mapper.AmortizationScheduleMapper;
import afrik.tech.cima.alm.investment.repository.AmortizationScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class AmortizationScheduleService extends AbstractCrudService<AmortizationSchedule, AmortizationScheduleDto> {

    public AmortizationScheduleService(AmortizationScheduleRepository repository, AmortizationScheduleMapper mapper) {
        super(repository, mapper, "Ligne d'amortissement");
    }
}
