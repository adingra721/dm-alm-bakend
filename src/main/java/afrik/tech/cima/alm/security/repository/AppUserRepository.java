package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
