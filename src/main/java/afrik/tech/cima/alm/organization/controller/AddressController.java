package afrik.tech.cima.alm.organization.controller;

import afrik.tech.cima.alm.common.controller.AbstractCrudController;
import afrik.tech.cima.alm.organization.dto.AddressDto;
import afrik.tech.cima.alm.organization.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organisation/adresses")
public class AddressController extends AbstractCrudController<AddressDto> {

    public AddressController(AddressService service) {
        super(service);
    }
}
