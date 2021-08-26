package com.jode.site.jodeApi.domain;

import java.util.List;
import java.util.Optional;

public interface PresenteRepository {
    Presente save(Presente presente);

    List<Presente> findAll();

    Optional<Presente> findById(Long id);

    List<Presente> findByCategoriaId(Long categoriaId);

    void deleteById(Long id);
}
