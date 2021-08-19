package com.jode.site.jodeApi.infrastructure.repositories;

import com.jode.site.jodeApi.domain.Presente;
import com.jode.site.jodeApi.domain.PresenteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PresenteJpaRespository extends CrudRepository<Presente, Long>, PresenteRepository {
}
