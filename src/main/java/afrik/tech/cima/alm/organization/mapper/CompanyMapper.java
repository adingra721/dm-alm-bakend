package afrik.tech.cima.alm.organization.mapper;

import afrik.tech.cima.alm.common.mapper.GenericMapper;
import afrik.tech.cima.alm.organization.dto.CompanyDto;
import afrik.tech.cima.alm.organization.entity.Address;
import afrik.tech.cima.alm.organization.entity.Company;
import afrik.tech.cima.alm.organization.entity.Country;
import afrik.tech.cima.alm.organization.entity.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends GenericMapper<Company, CompanyDto> {

    @Override
    @Mapping(source = "pays.id", target = "paysId")
    @Mapping(source = "deviseFonctionnelle.id", target = "deviseFonctionnelleId")
    @Mapping(source = "adresseSiege.id", target = "adresseSiegeId")
    CompanyDto toDto(Company entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "paysId", target = "pays")
    @Mapping(source = "deviseFonctionnelleId", target = "deviseFonctionnelle")
    @Mapping(source = "adresseSiegeId", target = "adresseSiege")
    Company toEntity(CompanyDto dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "paysId", target = "pays")
    @Mapping(source = "deviseFonctionnelleId", target = "deviseFonctionnelle")
    @Mapping(source = "adresseSiegeId", target = "adresseSiege")
    void updateEntity(CompanyDto dto, @MappingTarget Company entity);

    default Country mapCountry(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }

    default Currency mapCurrency(Long id) {
        if (id == null) {
            return null;
        }
        Currency currency = new Currency();
        currency.setId(id);
        return currency;
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
