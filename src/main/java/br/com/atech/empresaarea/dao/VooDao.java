package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Voo;

import java.util.List;
import java.util.Optional;

public interface VooDao {

    Optional<Voo> getOne(Long id);

    Optional<List<Voo>> findAll();

    Optional<Voo> saveAndFlush(Voo entity);

    Optional<Voo> save(Voo entity);

}
