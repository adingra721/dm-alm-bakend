package afrik.tech.cima.alm.organization.repository;

import afrik.tech.cima.alm.organization.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
