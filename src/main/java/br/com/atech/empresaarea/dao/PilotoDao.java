package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Piloto;
import br.com.atech.empresaarea.dao.domain.Voo;

import java.util.List;
import java.util.Optional;

public interface PilotoDao {

    Optional<Piloto> getOne(Long id);

    Optional<Piloto> saveAndFlush(Piloto entity);

    Optional<List<Piloto>> findAll();

    Optional<Piloto> save(Piloto entity);

}
