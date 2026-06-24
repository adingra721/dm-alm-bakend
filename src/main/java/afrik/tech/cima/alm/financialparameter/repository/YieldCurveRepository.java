package afrik.tech.cima.alm.financialparameter.repository;

import afrik.tech.cima.alm.financialparameter.entity.YieldCurve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YieldCurveRepository extends JpaRepository<YieldCurve, Long> {
}
