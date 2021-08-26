package com.jode.site.jodeApi.infrastructure.dto.request;

import lombok.Data;


@Data
public class PresenteRequest {
    private Long id;
    private String nome;
    private double preco;
    private Long categoria;
    private boolean disponibilidade;
    private String link;
    private String imagem;
    private String senha;
}
