package com.jode.site.jodeApi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String celular;

    @ManyToOne(optional = false)
    @JoinColumn(name = "presente_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Presente produto;

    private Long quantidade;
    private Long parcelas;
    private Long numeroParcela;

    @Temporal(TemporalType.DATE)
    private Date dataCobranca;

    private boolean envioBoleto;
    private boolean pagamento;
}
