package afrik.tech.cima.alm.organization.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.organization.dto.AddressDto;
import afrik.tech.cima.alm.organization.entity.Address;
import afrik.tech.cima.alm.organization.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<Address, AddressDto> {

    @Override
    @Mapping(source = "pays.id", target = "paysId")
    AddressDto toDto(Address entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "paysId", target = "pays")
    Address toEntity(AddressDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "paysId", target = "pays")
    void updateEntity(AddressDto dto, @MappingTarget Address entity);

    default Country mapCountry(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }
}
