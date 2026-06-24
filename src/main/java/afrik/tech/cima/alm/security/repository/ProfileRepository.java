package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
