package sistema.reservasalas.dao;

import java.util.List;

import sistema.reservasalas.beans.Sala;

public interface SalaDao {
	
	void save(Sala sala);
	
	void update(Sala sala);
	
	void delete(Long id);
	
	Sala findById(Long id);
	
	List<Sala> findAll();
	

}
