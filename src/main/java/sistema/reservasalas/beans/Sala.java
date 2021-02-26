package sistema.reservasalas.beans;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SALAS")
public class Sala extends AbstractEntity<Long>{
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int lotacao;
	
	@Column(nullable = true)
	private int lotacao_atual;

	
	//Guetters e Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLotacao() {
		return lotacao;
	}

	public int getLotacao_atual() {
		return lotacao_atual;
	}

	public void setLotacao_atual(int lotacao_atual) {
		this.lotacao_atual = lotacao_atual;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}
	
	

}
