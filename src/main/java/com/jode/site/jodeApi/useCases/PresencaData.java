package com.jode.site.jodeApi.useCases;

import com.jode.site.jodeApi.domain.Presenca;
import com.jode.site.jodeApi.domain.PresencaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PresencaData {

    private final PresencaRepository presencaRepository;

    public Presenca create(Presenca presenca) {
        return this.presencaRepository.save(presenca);
    }

    public List<Presenca> getAll() {
        return this.presencaRepository.findAll();
    }
}
