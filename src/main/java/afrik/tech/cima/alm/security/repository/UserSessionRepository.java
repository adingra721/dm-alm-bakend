package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {

    Optional<UserSession> findBySessionTokenAndActiveTrue(String sessionToken);
}
