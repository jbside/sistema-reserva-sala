package sistema.reservasalas.beans;

import javax.persistence.Entity;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table
public class Aluno extends AbstractEntity<Long>{
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sobre_nome;
	
	@ManyToOne
	@JoinColumn(name = "sala_id_fk")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name = "sala2_id_fk")
	private Sala sala2;
	
	@ManyToOne
	@JoinColumn(name = "espaco_id_fk")
	private Espaco espaco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobre_nome() {
		return sobre_nome;
	}

	public void setSobre_nome(String sobre_nome) {
		this.sobre_nome = sobre_nome;
	}

	public Sala getSala2() {
		return sala2;
	}

	public void setSala2(Sala sala2) {
		this.sala2 = sala2;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
	}

}
