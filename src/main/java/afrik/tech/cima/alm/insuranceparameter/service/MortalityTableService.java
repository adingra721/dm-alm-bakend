package afrik.tech.cima.alm.insuranceparameter.service;

import afrik.tech.cima.alm.common.dto.ReferenceDto;
import afrik.tech.cima.alm.common.service.AbstractCrudService;
import afrik.tech.cima.alm.insuranceparameter.entity.MortalityTable;
import afrik.tech.cima.alm.insuranceparameter.mapper.MortalityTableMapper;
import afrik.tech.cima.alm.insuranceparameter.repository.MortalityTableRepository;
import org.springframework.stereotype.Service;

@Service
public class MortalityTableService extends AbstractCrudService<MortalityTable, ReferenceDto> {
    public MortalityTableService(MortalityTableRepository repository, MortalityTableMapper mapper) {
        super(repository, mapper, "Table de mortalite");
    }
}
