package com.jode.site.jodeApi.useCases;

import com.jode.site.jodeApi.domain.Categoria;
import com.jode.site.jodeApi.domain.Presente;
import com.jode.site.jodeApi.domain.PresenteRepository;
import com.jode.site.jodeApi.infrastructure.dto.request.PresenteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PresenteData {
    private PresenteRepository presenteRepository;
    private final CategoriaData categoriaData;

    public Presente create(PresenteRequest presenteRequest) {
        Optional<Categoria> categoria = this.categoriaData.getById(presenteRequest.getCategoria());
        if(categoria.isPresent()) {
            Presente presente = new Presente(
                    null,
                    presenteRequest.getNome(),
                    presenteRequest.getPreco(),
                    categoria.get(),
                    presenteRequest.isDisponibilidade(),
                    presenteRequest.getLink(),
                    presenteRequest.getImagem()
            );
            return this.presenteRepository.save(presente);
        } else {
            return null;
        }

    }

    public List<Presente> getAll() {
        return this.presenteRepository.findAll();
    }

    public Optional<Presente> getById(Long id) {
        return this.presenteRepository.findById(id);
    }

    public List<Presente> getAllByCategoria(Long idCategoria) {
        return this.presenteRepository.findByCategoriaId(idCategoria);
    }
    public Presente edit(PresenteRequest presenteRequest, Long id) {
        Optional<Presente> presente = this.presenteRepository.findById(id);
        Optional<Categoria> categoria = this.categoriaData.getById(presenteRequest.getCategoria());
        if(categoria.isPresent() && presente.isPresent()) {
            Presente presenteEditado = presente.get();
            presenteEditado.setNome(presenteRequest.getNome());
            presenteEditado.setDisponibilidade(presenteRequest.isDisponibilidade());
            presenteEditado.setCategoria(categoria.get());
            presenteEditado.setPreco(presenteRequest.getPreco());
            presenteEditado.setLink(presenteRequest.getLink());
            presenteEditado.setImagem(presenteRequest.getImagem());
            return this.presenteRepository.save(presenteEditado);
        } else {
            return null;
        }

    }

    public void delete(Long id) {
        this.presenteRepository.deleteById(id);
    }

}
