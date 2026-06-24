package afrik.tech.cima.alm.investment.repository;

import afrik.tech.cima.alm.investment.entity.FinancialAsset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialAssetRepository extends JpaRepository<FinancialAsset, Long> {
}
