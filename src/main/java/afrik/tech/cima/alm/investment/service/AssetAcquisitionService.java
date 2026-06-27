package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.exception.BadRequestException;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.AssetAcquisitionDto;
import afrik.tech.cima.alm.investment.entity.AssetAcquisition;
import afrik.tech.cima.alm.investment.mapper.AssetAcquisitionMapper;
import afrik.tech.cima.alm.investment.repository.AssetAcquisitionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Service
public class AssetAcquisitionService extends AbstractCrudService<AssetAcquisition, AssetAcquisitionDto> {

    private static final String BROUILLON = "BROUILLON";
    private static final String SOUMIS = "SOUMIS";
    private static final String AUTORISE = "AUTORISE";
    private static final String VALIDE = "VALIDE";
    private static final String REJETE = "REJETE";

    private static final Map<String, Set<String>> TRANSITIONS = Map.of(
            "submit", Set.of(BROUILLON, REJETE),
            "authorize", Set.of(SOUMIS),
            "validate", Set.of(AUTORISE),
            "reject", Set.of(SOUMIS, AUTORISE),
            "reactivate", Set.of(VALIDE, REJETE)
    );

    private final AssetAcquisitionRepository repository;
    private final AssetAcquisitionMapper mapper;

    public AssetAcquisitionService(AssetAcquisitionRepository repository, AssetAcquisitionMapper mapper) {
        super(repository, mapper, "Dossier d'acquisition");
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public AssetAcquisitionDto applyWorkflowAction(Long id, String action, String commentaire, String utilisateur) {
        AssetAcquisition entity = findEntity(id);
        String normalizedAction = normalizeAction(action);
        String currentStatus = normalizeStatus(entity.getStatut(), BROUILLON);
        Set<String> allowedStatuses = TRANSITIONS.get(normalizedAction);

        if (allowedStatuses == null || !allowedStatuses.contains(currentStatus)) {
            throw new BadRequestException("Transition non autorisee depuis le statut " + currentStatus + ".");
        }

        switch (normalizedAction) {
            case "submit" -> {
                entity.setStatut(SOUMIS);
                entity.setDateSoumission(LocalDate.now());
                entity.setGestionnaire(firstNonBlank(utilisateur, entity.getGestionnaire()));
                entity.setMotifRejet(null);
            }
            case "authorize" -> {
                entity.setStatut(AUTORISE);
                entity.setDateAutorisation(LocalDate.now());
                entity.setDaf(firstNonBlank(utilisateur, entity.getDaf()));
            }
            case "validate" -> {
                entity.setStatut(VALIDE);
                entity.setDateValidation(LocalDate.now());
                entity.setDg(firstNonBlank(utilisateur, entity.getDg()));
            }
            case "reject" -> {
                entity.setStatut(REJETE);
                entity.setMotifRejet(firstNonBlank(commentaire, "Dossier rejete dans le workflow de validation."));
            }
            case "reactivate" -> {
                entity.setStatut(BROUILLON);
                entity.setMotifRejet(null);
            }
            default -> throw new BadRequestException("Action workflow inconnue.");
        }

        return mapper.toDto(repository.save(entity));
    }

    private String normalizeAction(String action) {
        if (action == null || action.isBlank()) {
            throw new BadRequestException("Action workflow obligatoire.");
        }
        return action.trim().toLowerCase();
    }

    private String normalizeStatus(String status, String fallback) {
        return status == null || status.isBlank() ? fallback : status.trim().toUpperCase();
    }

    private String firstNonBlank(String candidate, String fallback) {
        return candidate == null || candidate.isBlank() ? fallback : candidate.trim();
    }
}
