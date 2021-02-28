package sistema.reservasalas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistema.reservasalas.beans.Sala;
import sistema.reservasalas.dao.SalaDao;

@Service
@Transactional(readOnly = true)
public class SalasServiceImpl implements SalasService {

	@Autowired
	private SalaDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Sala sala) {
		dao.save(sala);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Sala sala) {
		dao.update(sala);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Sala buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sala> buscarTodos() {
		return dao.findAll();
	}
}
