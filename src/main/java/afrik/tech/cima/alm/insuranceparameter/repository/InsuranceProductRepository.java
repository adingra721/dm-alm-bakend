package afrik.tech.cima.alm.insuranceparameter.repository;

import afrik.tech.cima.alm.insuranceparameter.entity.InsuranceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceProductRepository extends JpaRepository<InsuranceProduct, Long> {
}
