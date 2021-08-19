package com.jode.site.jodeApi.infrastructure.controllers;

import com.jode.site.jodeApi.domain.Presente;
import com.jode.site.jodeApi.infrastructure.dto.request.PresenteRequest;
import com.jode.site.jodeApi.useCases.PresenteData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresenteController {
    private final PresenteData presenteData;

    public PresenteController(PresenteData presenteData) {
        this.presenteData = presenteData;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/presente")
    public Presente createPresente(@RequestBody PresenteRequest presente) {
        return this.presenteData.create(presente);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/presente")
    public List<Presente> getAllPresente() {
        return this.presenteData.getAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/presente/categoria/{idCategoria}")
    public List<Presente> getAllPresenteByCategoria(@PathVariable(required = true) Long idCategoria) {
        return this.presenteData.getAllByCategoria(idCategoria);
    }
}
