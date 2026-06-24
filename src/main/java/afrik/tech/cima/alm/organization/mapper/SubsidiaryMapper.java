package afrik.tech.cima.alm.organization.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.organization.dto.SubsidiaryDto;
import afrik.tech.cima.alm.organization.entity.Address;
import afrik.tech.cima.alm.organization.entity.Company;
import afrik.tech.cima.alm.organization.entity.Country;
import afrik.tech.cima.alm.organization.entity.Subsidiary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubsidiaryMapper extends GenericMapper<Subsidiary, SubsidiaryDto> {

    @Override
    @Mapping(source = "compagnie.id", target = "compagnieId")
    @Mapping(source = "pays.id", target = "paysId")
    @Mapping(source = "adresse.id", target = "adresseId")
    SubsidiaryDto toDto(Subsidiary entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "compagnieId", target = "compagnie")
    @Mapping(source = "paysId", target = "pays")
    @Mapping(source = "adresseId", target = "adresse")
    Subsidiary toEntity(SubsidiaryDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "compagnieId", target = "compagnie")
    @Mapping(source = "paysId", target = "pays")
    @Mapping(source = "adresseId", target = "adresse")
    void updateEntity(SubsidiaryDto dto, @MappingTarget Subsidiary entity);

    default Company mapCompany(Long id) {
        if (id == null) {
            return null;
        }
        Company company = new Company();
        company.setId(id);
        return company;
    }

    default Country mapCountry(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }

    default Address mapAddress(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}
