package sistema.reservasalas.service;

import java.util.List;

import sistema.reservasalas.beans.Sala;

public interface SalasService {
	
	void salvar(Sala sala);
	
	void editar(Sala sala);
	
	void excluir(Long id);
	
	Sala buscarPorId(Long id);
	
	List<Sala> buscarTodos();

	boolean tratarEntradaDeDados(String nome, int lotacao);
	
}
