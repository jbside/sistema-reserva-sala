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
	
	public void getLocacaoAtual(Long id1, Long id2);

	public void decrementarLotacaoQuandoUsuarioExcluir(Long id);

	public boolean verificaLotacaoSala(Long id1, Long id2);

	void alterarcaoLotacaoDaSala(Aluno sala,Long id1, Long id2);

	boolean tratarEntradaDeDados(String nome, String sobrenome, String sala, String sala2, String espaco);
}
