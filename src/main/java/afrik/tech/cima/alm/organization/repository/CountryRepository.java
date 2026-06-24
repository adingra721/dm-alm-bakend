package afrik.tech.cima.alm.organization.repository;

import afrik.tech.cima.alm.organization.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
