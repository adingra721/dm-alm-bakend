package afrik.tech.cima.alm.financialparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.financialparameter.entity.FinancialRating;
import afrik.tech.cima.alm.financialparameter.mapper.FinancialRatingMapper;
import afrik.tech.cima.alm.financialparameter.repository.FinancialRatingRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialRatingService extends AbstractCrudService<FinancialRating, ReferenceDto> {
    public FinancialRatingService(FinancialRatingRepository repository, FinancialRatingMapper mapper) {
        super(repository, mapper, "Notation financiere");
    }
}
