package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Cidade;
import br.com.atech.empresaarea.dao.repository.CidadeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CidadeDaoImpl extends CoreDao<Cidade,Long, CidadeRepository> implements CidadeDao {
}
