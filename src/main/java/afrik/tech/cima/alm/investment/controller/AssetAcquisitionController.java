package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AssetAcquisitionDto;
import afrik.tech.cima.alm.investment.dto.WorkflowActionRequest;
import afrik.tech.cima.alm.investment.service.AssetAcquisitionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/acquisitions")
public class AssetAcquisitionController extends AbstractCrudController<AssetAcquisitionDto> {

    private final AssetAcquisitionService acquisitionService;

    public AssetAcquisitionController(AssetAcquisitionService service) {
        super(service);
        this.acquisitionService = service;
    }

    @PostMapping("/{id}/workflow/{action}")
    public AssetAcquisitionDto workflowAction(@PathVariable Long id, @PathVariable String action,
                                              @RequestBody(required = false) WorkflowActionRequest request) {
        return acquisitionService.applyWorkflowAction(
                id,
                action,
                request == null ? null : request.commentaire(),
                request == null ? null : request.utilisateur()
        );
    }
}
