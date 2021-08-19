package com.jode.site.jodeApi.infrastructure.dto.request;


import lombok.Data;

@Data
public class CompraRequest {

    private Long id;
    private String nome;
    private String email;
    private String celular;
    private long idProduto;
    private Long quantidade;
    private Long parcelas;
}
