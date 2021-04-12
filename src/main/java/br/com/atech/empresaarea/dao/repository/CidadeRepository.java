package br.com.atech.empresaarea.dao.repository;

import br.com.atech.empresaarea.dao.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CidadeRepository extends JpaRepository<Cidade,Long> {
}
