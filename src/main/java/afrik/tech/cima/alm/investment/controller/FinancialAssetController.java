package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.FinancialAssetDto;
import afrik.tech.cima.alm.investment.dto.WorkflowActionRequest;
import afrik.tech.cima.alm.investment.service.FinancialAssetService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/actifs")
public class FinancialAssetController extends AbstractCrudController<FinancialAssetDto> {

    private final FinancialAssetService financialAssetService;

    public FinancialAssetController(FinancialAssetService service) {
        super(service);
        this.financialAssetService = service;
    }

    @PostMapping("/{id}/workflow/{action}")
    public FinancialAssetDto workflowAction(@PathVariable Long id, @PathVariable String action,
                                            @RequestBody(required = false) WorkflowActionRequest request) {
        return financialAssetService.applyWorkflowAction(
                id,
                action,
                request == null ? null : request.commentaire()
        );
    }
}
