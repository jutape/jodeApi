package com.jode.site.jodeApi.domain;

import java.util.List;

public interface PresencaRepository {
    Presenca save(Presenca presenca);

    List<Presenca> findAll();
}
