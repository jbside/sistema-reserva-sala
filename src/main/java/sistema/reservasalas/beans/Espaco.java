package sistema.reservasalas.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "ESPACOS")
public class Espaco extends AbstractEntity<Long> {
	
	@Column(nullable = false)
	private String nome;

	//Guetters e Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
