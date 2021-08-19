package com.jode.site.jodeApi.domain;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Categoria save(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);
}
