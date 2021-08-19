package com.jode.site.jodeApi.infrastructure.controllers;

import com.jode.site.jodeApi.domain.Presenca;
import com.jode.site.jodeApi.useCases.PresencaData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RsvpController {

    private final PresencaData presencaData;

    public RsvpController(PresencaData presencaData) {
        this.presencaData = presencaData;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/presenca")
    public List<Presenca> getAllPresenca() {
        return this.presencaData.getAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/presenca")
    public Presenca createPresenca(@RequestBody Presenca presenca) {
        return this.presencaData.create(presenca);
    }

}
