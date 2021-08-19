package com.jode.site.jodeApi.infrastructure.controllers;

import com.jode.site.jodeApi.domain.Categoria;
import com.jode.site.jodeApi.useCases.CategoriaData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {
    private final CategoriaData categoriaData;

    public CategoriaController(CategoriaData categoriaData) {
        this.categoriaData = categoriaData;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/categoria")
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return this.categoriaData.create(categoria);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/categoria")
    public List<Categoria> getAllCategoria() {
        return this.categoriaData.getAll();
    }
}
