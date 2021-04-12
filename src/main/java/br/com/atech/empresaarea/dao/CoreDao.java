package br.com.atech.empresaarea.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class CoreDao<T, ID, R extends JpaRepository<T,ID>> {

    @Autowired
    protected R repository;

    @Transactional(readOnly = true)
    public Optional<List<T>> findAll(){
        return Optional.ofNullable(repository.findAll());
    };

    public Optional<List<T>> saveAll(Iterable<T> entities){
        return Optional.ofNullable(repository.saveAll(entities));
    }

    public void flush(){
        repository.flush();
    };

    public <S extends T> S saveAndFlush(S entity){
        return repository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<T> entities){
        repository.deleteInBatch(entities);
    }

    @Transactional(readOnly = true)
    public Optional<T> getOne(ID id){
        return Optional.ofNullable(repository.getOne(id));
    }

    public Optional<T> save(T entity) {
        return Optional.ofNullable(repository.save(entity));
    }

    public Optional<List<T>> findAllById(List<ID> ids){return Optional.ofNullable(repository.findAllById(ids));}

}
