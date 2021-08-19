package com.jode.site.jodeApi.infrastructure.repositories;

import com.jode.site.jodeApi.domain.Presenca;
import com.jode.site.jodeApi.domain.PresencaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaJpaRepository extends JpaRepository<Presenca, Long>, PresencaRepository {
}
