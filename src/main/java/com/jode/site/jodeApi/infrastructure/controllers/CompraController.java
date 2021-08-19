package com.jode.site.jodeApi.infrastructure.controllers;

import com.jode.site.jodeApi.domain.Compra;
import com.jode.site.jodeApi.infrastructure.dto.request.CompraRequest;
import com.jode.site.jodeApi.useCases.CompraData;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompraController {

    private CompraData compraData;

    CompraController(CompraData compraData) {
        this.compraData = compraData;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/compra")
    public List<Compra> buscarCompras() {
        return this.compraData.getAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/api/compra")
    public void comprar(@RequestBody CompraRequest compraRequest) throws Exception {
        this.compraData.create(compraRequest);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/compra/notificado/{id}")
    public Compra notificar(@PathVariable(required = true) Long id) {
        return this.compraData.changeEnvioBoleto(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/compra/pago/{id}")
    public Compra pagar(@PathVariable(required = true) Long id) {
        return this.compraData.changepagamento(id);
    }

}
