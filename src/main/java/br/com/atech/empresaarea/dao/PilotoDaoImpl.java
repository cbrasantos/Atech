package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Piloto;
import br.com.atech.empresaarea.dao.repository.PilotoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PilotoDaoImpl extends CoreDao<Piloto,Long, PilotoRepository > implements PilotoDao {



}
