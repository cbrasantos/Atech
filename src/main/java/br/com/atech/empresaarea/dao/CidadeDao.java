package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Cidade;
import br.com.atech.empresaarea.dao.domain.Piloto;

import java.util.List;
import java.util.Optional;

public interface CidadeDao {

    Optional<Cidade> getOne(Long id);

    Optional<Cidade> saveAndFlush(Cidade entity);

    Optional<List<Cidade>> findAll();

    Optional<Cidade> save(Cidade entity);

}
