package afrik.tech.cima.alm.investment.repository;

import afrik.tech.cima.alm.investment.entity.AmortizationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmortizationScheduleRepository extends JpaRepository<AmortizationSchedule, Long> {
}
