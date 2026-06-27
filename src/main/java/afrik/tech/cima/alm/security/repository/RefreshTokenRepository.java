package afrik.tech.cima.alm.security.repository;

import afrik.tech.cima.alm.security.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByTokenHashAndActiveTrue(String tokenHash);
}
