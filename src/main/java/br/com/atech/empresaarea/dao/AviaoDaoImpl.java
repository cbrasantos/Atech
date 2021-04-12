package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Aviao;
import br.com.atech.empresaarea.dao.repository.AviaoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AviaoDaoImpl extends CoreDao<Aviao,Long, AviaoRepository> implements AviaoDao{
}
