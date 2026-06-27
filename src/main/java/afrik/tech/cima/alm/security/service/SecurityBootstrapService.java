package afrik.tech.cima.alm.security.service;

import afrik.tech.cima.alm.security.entity.AppUser;
import afrik.tech.cima.alm.security.entity.Profile;
import afrik.tech.cima.alm.security.repository.AppUserRepository;
import afrik.tech.cima.alm.security.repository.ProfileRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SecurityBootstrapService implements ApplicationRunner {

    private static final String DEFAULT_PASSWORD = "Admin@12345";

    private final AppUserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final PasswordService passwordService;

    public SecurityBootstrapService(AppUserRepository userRepository, ProfileRepository profileRepository,
                                    PasswordService passwordService) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.passwordService = passwordService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        Profile adminProfile = profileRepository.findByCode("ADMIN").orElseGet(this::createAdminProfile);
        AppUser admin = userRepository.findByUsername("admin").orElseGet(AppUser::new);

        admin.setUsername("admin");
        admin.setEmail("admin@afrik.tech");
        admin.setNomComplet("Administrateur CIMA ALM");
        admin.setProfil(adminProfile);
        admin.setActif(true);
        admin.setPasswordChangeRequired(false);
        admin.setFailedLoginAttempts(0);
        admin.setLockedUntil(null);

        if (admin.getPasswordHash() == null || admin.getPasswordHash().startsWith("$2a$") || admin.getPasswordHash().contains("replace-with-real")) {
            admin.setPasswordHash(passwordService.hash(DEFAULT_PASSWORD));
        }

        userRepository.save(admin);
    }

    private Profile createAdminProfile() {
        Profile profile = new Profile();
        profile.setCode("ADMIN");
        profile.setLibelle("Administrateur");
        profile.setDescription("Acces complet au parametrage et a la securite");
        profile.setActif(true);
        return profileRepository.save(profile);
    }
}
