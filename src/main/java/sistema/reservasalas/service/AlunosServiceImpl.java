package sistema.reservasalas.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@Autowired
	AlunosService alunoService;

	@Autowired
	private SalasService salaService;

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

	// Metodo que incrementa a lotacao atual da sala quando usuario novo cadastra

	@Override
	@Transactional(readOnly = true)
	public void getLocacaoAtual(Long id1, Long id2) {
		if (salaService.buscarPorId(id1).equals(salaService.buscarPorId(id2))) {
			int lotacao = salaService.buscarPorId(id1).getLotacao_atual() + 1;
			salaService.buscarPorId(id1).setLotacao_atual(lotacao);
		} else {
			int lotacao = salaService.buscarPorId(id1).getLotacao_atual() + 1;
			salaService.buscarPorId(id1).setLotacao_atual(lotacao);

			int lotacao2 = salaService.buscarPorId(id2).getLotacao_atual() + 1;
			salaService.buscarPorId(id2).setLotacao_atual(lotacao2);
		}

	}

	// Metodo que descrementa a lotacao atual da sala quando usuario é excluido

	@Override
	@Transactional(readOnly = true)
	public void decrementarLotacaoQuandoUsuarioExcluir(Long id) {

		String Cid1 = alunoService.buscarPorId(id).getSala().toString().substring(4);
		String Cid2 = alunoService.buscarPorId(id).getSala2().toString().substring(4);

		Long id1 = Long.parseLong(Cid1);
		Long id2 = Long.parseLong(Cid2);

		if (salaService.buscarPorId(id1).equals(salaService.buscarPorId(id2))) {
			int lotacao = salaService.buscarPorId(id1).getLotacao_atual() - 1;
			salaService.buscarPorId(id1).setLotacao_atual(lotacao);
		} else {
			int lotacao = salaService.buscarPorId(id1).getLotacao_atual() - 1;
			salaService.buscarPorId(id1).setLotacao_atual(lotacao);

			int lotacao2 = salaService.buscarPorId(id2).getLotacao_atual() - 1;
			salaService.buscarPorId(id2).setLotacao_atual(lotacao2);
		}

	}

	// Metodo que verificar se aluno pode reservar a sala se a lotação estiver livre
	
	@Override
	@Transactional(readOnly = true)
	public boolean verificaLotacaoSala(Long id1, Long id2) {
		if (salaService.buscarPorId(id1).getLotacao_atual() < salaService.buscarPorId(id1).getLotacao()
				&& salaService.buscarPorId(id2).getLotacao_atual() < salaService.buscarPorId(id2).getLotacao()) {
			return true;
		} else {

			return false;
		}
	}
	
	//Metodo que altera a lotação atual das salas, caso cadastro do aluno for alterado
	
	@Override
	@Transactional(readOnly = true)
	public void alterarcaoLotacaoDaSala(Aluno aluno,Long id1, Long id2) {
		
		String PidAluno = aluno.getId().toString();
		Long idAluno = Long.parseLong(PidAluno);
		
		if (alunoService.buscarPorId(idAluno).getSala().equals(id1) 
				&& alunoService.buscarPorId(idAluno).getSala2().equals(id2)){
			
		} else {
			
			int lotacao = salaService.buscarPorId(id1).getLotacao_atual() + 1;
			salaService.buscarPorId(id1).setLotacao_atual(lotacao);
			
			lotacao = alunoService.buscarPorId(idAluno).getSala().getLotacao_atual() - 1;
			alunoService.buscarPorId(idAluno).getSala().setLotacao_atual(lotacao);
			
			lotacao = salaService.buscarPorId(id2).getLotacao_atual() + 1;
			salaService.buscarPorId(id2).setLotacao_atual(lotacao);
			
			lotacao = alunoService.buscarPorId(idAluno).getSala2().getLotacao_atual() -1;
			alunoService.buscarPorId(idAluno).getSala2().setLotacao_atual(lotacao);
			
		}
		
		
	}

}
