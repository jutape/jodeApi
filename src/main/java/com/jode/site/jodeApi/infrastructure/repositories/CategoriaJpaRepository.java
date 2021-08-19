package com.jode.site.jodeApi.infrastructure.repositories;

import com.jode.site.jodeApi.domain.Categoria;
import com.jode.site.jodeApi.domain.CategoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaJpaRepository extends JpaRepository<Categoria, Long>, CategoriaRepository {
}
