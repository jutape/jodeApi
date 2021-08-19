package com.jode.site.jodeApi.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CompraRepository {
    Compra save(Compra compra);

    List<Compra> findAll();

    Optional<Compra> findById(Long id);

    List<Compra> findByDataCobrancaLessThanEqualAndPagamentoIsFalse(Date date);

}
