package sistema.reservasalas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import sistema.reservasalas.beans.Aluno;

@Repository
public class AlunoDaoImpl extends AbstractDao<Aluno, Long> implements AlunoDao {

	@Override
	public List<Aluno> findByNome(String nome) {
		return createQuery("select a from Aluno a where a.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Aluno> findBySala(Long id) {
		return createQuery("select a from Aluno a where a.sala.id =?1", id);
	}

	@Override
	public List<Aluno> findByEspaco(Long id) {
		return createQuery("select a from Aluno a where a.espaco.id =?1", id);
	}

}
