package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Aviao;

import java.util.List;
import java.util.Optional;

public interface AviaoDao {

    Optional<Aviao> getOne(Long id);

    Optional<Aviao> saveAndFlush(Aviao entity);

    Optional<List<Aviao>> findAll();

    Optional<Aviao> save(Aviao entity);

}
