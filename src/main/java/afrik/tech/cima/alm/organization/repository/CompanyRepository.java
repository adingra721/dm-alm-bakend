package afrik.tech.cima.alm.organization.repository;

import afrik.tech.cima.alm.organization.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
