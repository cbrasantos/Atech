package br.com.atech.empresaarea.dao;

import br.com.atech.empresaarea.dao.domain.Voo;
import br.com.atech.empresaarea.dao.repository.VooRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VooDaoImpl extends CoreDao<Voo,Long, VooRepository> implements VooDao {


}
