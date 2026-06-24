package afrik.tech.cima.alm.common.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtos(List<E> entities);

    void updateEntity(D dto, @MappingTarget E entity);
}
