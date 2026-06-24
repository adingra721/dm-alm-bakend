package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
