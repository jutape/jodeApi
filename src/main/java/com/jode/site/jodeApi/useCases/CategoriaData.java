package com.jode.site.jodeApi.useCases;

import com.jode.site.jodeApi.domain.Categoria;
import com.jode.site.jodeApi.domain.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CategoriaData {

    private CategoriaRepository categoriaRepository;

    public Categoria create(Categoria Categoria) {
        return this.categoriaRepository.save(Categoria);
    }

    public List<Categoria> getAll() {
        return this.categoriaRepository.findAll();
    }

    public Optional<Categoria> getById(Long id) {
        return this.categoriaRepository.findById(id);
    }
}
