package com.jode.site.jodeApi.useCases;

import com.jode.site.jodeApi.DataProvider.JavaEmail;
import com.jode.site.jodeApi.domain.Compra;
import com.jode.site.jodeApi.domain.CompraRepository;
import com.jode.site.jodeApi.domain.Presente;
import com.jode.site.jodeApi.domain.PresenteRepository;
import com.jode.site.jodeApi.infrastructure.dto.request.CompraRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.jode.site.jodeApi.Utils.addOneMonth;

@Service
@Transactional
@AllArgsConstructor
public class CompraData {

    private final CompraRepository compraRepository;
    private final PresenteRepository presenteRepository;
    private JavaEmail javaEmail;

    public void create(CompraRequest compraRequest) throws Exception {
        Optional<Presente> presente = presenteRepository.findById(compraRequest.getIdProduto());
        if(presente.isPresent()) {
            Presente valorPresente = presente.get();
            valorPresente.setDisponibilidade(false);
            for (int i = 0; i < compraRequest.getParcelas(); i++) {
                Compra compra = new Compra();
                compra.setNome(compraRequest.getNome());
                compra.setEmail(compraRequest.getEmail());
                compra.setCelular(compraRequest.getCelular());
                compra.setProduto(valorPresente);
                compra.setDataCobranca(addOneMonth(new Date(), i));
                compra.setQuantidade(compraRequest.getQuantidade());
                compra.setParcelas(compraRequest.getParcelas());
                compra.setEnvioBoleto(false);
                compra.setNumeroParcela((long) i+1);
                compra.setPagamento(false);

                this.presenteRepository.save(valorPresente);
                this.compraRepository.save(compra);
            }

        }else throw new Exception();
    }

    public List<Compra> getAll() {
        List<Compra> compras = this.compraRepository.findByDataCobrancaLessThanEqualAndPagamentoIsFalse(new Date());
        EmailData emailData = new EmailData();
        for(Compra compra: compras) {
            if(!compra.isEnvioBoleto())
                emailData.addProduto(compra);
            else if(!compra.isPagamento())
                emailData.addPayment(compra);
        }
        javaEmail.enviarEmail(emailData.toString());
        return compras;
    }

    public Compra changeEnvioBoleto(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if(compra.isPresent()) {
            Compra valorCompra = compra.get();
            valorCompra.setEnvioBoleto(true);
            return compraRepository.save(valorCompra);
        } else {
            return null;
        }

    }

    public Compra changepagamento(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        if(compra.isPresent()) {
            Compra valorCompra = compra.get();
            valorCompra.setPagamento(true);
            return compraRepository.save(valorCompra);
        } else {
            return null;
        }
    }
}