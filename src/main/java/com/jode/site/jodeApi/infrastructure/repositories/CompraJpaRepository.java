package com.jode.site.jodeApi.infrastructure.repositories;

import com.jode.site.jodeApi.domain.Compra;
import com.jode.site.jodeApi.domain.CompraRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraJpaRepository extends JpaRepository<Compra, Long>, CompraRepository {
}
