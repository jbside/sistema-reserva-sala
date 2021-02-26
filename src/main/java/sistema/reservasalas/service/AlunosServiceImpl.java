package sistema.reservasalas.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistema.reservasalas.beans.Aluno;
import sistema.reservasalas.dao.AlunoDao;

@Service
@Transactional(readOnly = true)
public class AlunosServiceImpl implements AlunosService {

	@Autowired
	private AlunoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Aluno aluno) {
		dao.save(aluno);	
		
	}

	@Transactional(readOnly = false)	
	@Override
	public void editar(Aluno aluno) {
		dao.update(aluno);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);	
	}
	
	@Override
	public Aluno buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Aluno> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Override
	public List<Aluno> buscarPorSala(Long id) {
		return dao.findBySala(id);
	}

	@Override
	public List<Aluno> buscarPorEspaco(Long id) {
		return dao.findByEspaco(id);
	}

}
