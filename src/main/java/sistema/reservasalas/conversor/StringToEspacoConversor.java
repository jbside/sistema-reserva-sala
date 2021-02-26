package sistema.reservasalas.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sistema.reservasalas.beans.Espaco;
import sistema.reservasalas.service.EspacoService;


@Component
public class StringToEspacoConversor implements Converter<String,Espaco> {

	@Autowired
	private EspacoService service;
	
	@Override
	public Espaco convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
