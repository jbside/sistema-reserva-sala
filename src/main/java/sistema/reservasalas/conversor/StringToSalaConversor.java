package sistema.reservasalas.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sistema.reservasalas.beans.Sala;
import sistema.reservasalas.service.SalasService;

@Component
public class StringToSalaConversor implements Converter<String,Sala> {

	@Autowired
	private SalasService service;
	
	@Override
	public Sala convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
	
	

}
