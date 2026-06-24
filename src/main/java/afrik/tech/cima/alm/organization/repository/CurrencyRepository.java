package afrik.tech.cima.alm.organization.repository;

import afrik.tech.cima.alm.organization.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
