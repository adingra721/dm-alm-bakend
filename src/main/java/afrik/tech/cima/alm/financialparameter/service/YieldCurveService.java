package afrik.tech.cima.alm.financialparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.financialparameter.entity.YieldCurve;
import afrik.tech.cima.alm.financialparameter.mapper.YieldCurveMapper;
import afrik.tech.cima.alm.financialparameter.repository.YieldCurveRepository;
import org.springframework.stereotype.Service;

@Service
public class YieldCurveService extends AbstractCrudService<YieldCurve, ReferenceDto> {
    public YieldCurveService(YieldCurveRepository repository, YieldCurveMapper mapper) {
        super(repository, mapper, "Courbe de taux");
    }
}
