package afrik.tech.cima.alm.financialparameter.repository;

import afrik.tech.cima.alm.financialparameter.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}
