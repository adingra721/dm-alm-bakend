package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.SecurityParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityParameterRepository extends JpaRepository<SecurityParameter, Long> {

    Optional<SecurityParameter> findByCodeAndActifTrue(String code);
}
