package sistema.reservasalas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistema.reservasalas.beans.Espaco;
import sistema.reservasalas.dao.EspacoDao;

@Service
@Transactional(readOnly = true)
public class EspacoServiceImpl implements EspacoService {

	@Autowired
	private EspacoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Espaco espaco) {
		dao.save(espaco);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Espaco espaco) {
		dao.update(espaco);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Espaco buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Espaco> buscarTodos() {
		return dao.findAll();
	}
	
	// Metodo que verificar sem algum campo está vazio
	
	@Override
	@Transactional(readOnly = true)
	public boolean tratarEntradas(String nome) {
		if (nome.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	

}
