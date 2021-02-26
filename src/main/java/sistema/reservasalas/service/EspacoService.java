package sistema.reservasalas.service;

import java.util.List;

import sistema.reservasalas.beans.Espaco;

public interface EspacoService {
	
	void salvar(Espaco espaco);
	
	void editar(Espaco espaco);
	
	void excluir(Long id);
	
	Espaco buscarPorId(Long id);
	
	List<Espaco> buscarTodos();

}
