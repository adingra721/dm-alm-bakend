package afrik.tech.cima.alm.investment.service;

import afrik.tech.cima.alm.common.exception.BadRequestException;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.investment.dto.FinancialAssetDto;
import afrik.tech.cima.alm.investment.entity.FinancialAsset;
import afrik.tech.cima.alm.investment.mapper.FinancialAssetMapper;
import afrik.tech.cima.alm.investment.repository.FinancialAssetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

@Service
public class FinancialAssetService extends AbstractCrudService<FinancialAsset, FinancialAssetDto> {

    private static final String BROUILLON = "BROUILLON";
    private static final String EN_CONTROLE = "EN_CONTROLE";
    private static final String EN_VALIDATION = "EN_VALIDATION";
    private static final String VALIDE = "VALIDE";
    private static final String ACTIF = "ACTIF";
    private static final String REJETE = "REJETE";

    private static final Map<String, Set<String>> TRANSITIONS = Map.of(
            "submit", Set.of(BROUILLON, REJETE),
            "control", Set.of(EN_CONTROLE),
            "validate", Set.of(EN_CONTROLE, EN_VALIDATION),
            "reject", Set.of(EN_CONTROLE, EN_VALIDATION, VALIDE),
            "activate", Set.of(VALIDE),
            "reactivate", Set.of(ACTIF, REJETE)
    );

    private final FinancialAssetRepository repository;
    private final FinancialAssetMapper mapper;

    public FinancialAssetService(FinancialAssetRepository repository, FinancialAssetMapper mapper) {
        super(repository, mapper, "Actif financier");
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public FinancialAssetDto applyWorkflowAction(Long id, String action, String commentaire) {
        FinancialAsset entity = findEntity(id);
        String normalizedAction = normalizeAction(action);
        String currentStatus = normalizeStatus(entity.getStatut(), BROUILLON);
        Set<String> allowedStatuses = TRANSITIONS.get(normalizedAction);

        if (allowedStatuses == null || !allowedStatuses.contains(currentStatus)) {
            throw new BadRequestException("Transition non autorisee depuis le statut " + currentStatus + ".");
        }

        switch (normalizedAction) {
            case "submit" -> {
                entity.setStatut(EN_CONTROLE);
                entity.setActif(true);
            }
            case "control", "validate" -> {
                entity.setStatut(VALIDE);
                entity.setActif(true);
            }
            case "activate" -> {
                entity.setStatut(ACTIF);
                entity.setActif(true);
            }
            case "reject" -> {
                if (commentaire == null || commentaire.isBlank()) {
                    throw new BadRequestException("Le motif de rejet est obligatoire.");
                }
                entity.setStatut(REJETE);
                entity.setActif(false);
            }
            case "reactivate" -> {
                entity.setStatut(BROUILLON);
                entity.setActif(true);
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
}
