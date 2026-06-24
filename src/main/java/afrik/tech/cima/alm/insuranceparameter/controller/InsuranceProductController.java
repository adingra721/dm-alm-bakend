package afrik.tech.cima.alm.insuranceparameter.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.insuranceparameter.service.InsuranceProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parametres-assurance/produits-assurance")
public class InsuranceProductController extends AbstractCrudController<ReferenceDto> {
    public InsuranceProductController(InsuranceProductService service) {
        super(service);
    }
}
