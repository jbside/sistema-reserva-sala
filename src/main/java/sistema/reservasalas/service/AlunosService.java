package sistema.reservasalas.service;

import java.util.List;

import sistema.reservasalas.beans.Aluno;

public interface AlunosService {
	
	void salvar(Aluno aluno);
	
	void editar(Aluno aluno);
	
	void excluir(Long id);
	
	Aluno buscarPorId(Long id);
	
	List<Aluno> buscarTodos();
	
	List<Aluno> buscarPorNome(String nome);
	
	List<Aluno> buscarPorSala(Long id);
	
	List<Aluno> buscarPorEspaco(Long id);
}
