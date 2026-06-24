package afrik.tech.cima.alm.organization.service;

import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.organization.dto.AddressDto;
import afrik.tech.cima.alm.organization.entity.Address;
import afrik.tech.cima.alm.organization.mapper.AddressMapper;
import afrik.tech.cima.alm.organization.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractCrudService<Address, AddressDto> {

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper, "Adresse");
    }
}
