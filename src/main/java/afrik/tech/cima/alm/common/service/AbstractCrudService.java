package afrik.tech.cima.alm.common.service;

import afrik.tech.cima.alm.common.entity.BaseEntity;
import afrik.tech.cima.alm.common.exception.ResourceNotFoundException;
import afrik.tech.cima.alm.common.mapper.GenericMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractCrudService<E extends BaseEntity, D> implements CrudService<D> {

    private final JpaRepository<E, Long> repository;
    private final GenericMapper<E, D> mapper;
    private final String resourceName;

    protected AbstractCrudService(JpaRepository<E, Long> repository, GenericMapper<E, D> mapper, String resourceName) {
        this.repository = repository;
        this.mapper = mapper;
        this.resourceName = resourceName;
    }

    @Override
    @Transactional(readOnly = true)
    public List<D> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public D findById(Long id) {
        return mapper.toDto(findEntity(id));
    }

    @Override
    @Transactional
    public D create(D dto) {
        E entity = mapper.toEntity(dto);
        entity.setId(null);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional
    public D update(Long id, D dto) {
        E entity = findEntity(id);
        mapper.updateEntity(dto, entity);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(findEntity(id));
    }

    protected E findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resourceName + " introuvable avec id=" + id));
    }
}
