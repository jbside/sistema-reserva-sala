package sistema.reservasalas.dao;

import java.util.List;

import sistema.reservasalas.beans.Aluno;

public interface AlunoDao {

	 void save(Aluno aluno);
	
	 void update(Aluno aluno);
	
	 void delete(Long id);
	
	 Aluno findById(Long id);
	
	 List<Aluno> findAll();
	
	List<Aluno> findByNome(String nome);
	
	List<Aluno> findBySala(Long id);
	
	List<Aluno> findByEspaco(Long id);
}
