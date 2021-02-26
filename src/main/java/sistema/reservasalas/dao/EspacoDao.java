package sistema.reservasalas.dao;

import java.util.List;

import sistema.reservasalas.beans.Espaco;

public interface EspacoDao {
	
	void save(Espaco espaco);
	
	void update(Espaco espaco);
	
	void delete(Long id);
	
	Espaco findById(Long id);
	
	List<Espaco> findAll();

}
