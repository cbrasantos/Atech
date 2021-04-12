package br.com.atech.empresaarea.dao.repository;

import br.com.atech.empresaarea.dao.domain.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<Piloto,Long> {
}
