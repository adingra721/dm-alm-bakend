package afrik.tech.cima.alm.investment.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.investment.dto.AccountingMappingDto;
import afrik.tech.cima.alm.investment.service.AccountingMappingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/investissements/mappings-comptables")
public class AccountingMappingController extends AbstractCrudController<AccountingMappingDto> {

    public AccountingMappingController(AccountingMappingService service) {
        super(service);
    }
}
