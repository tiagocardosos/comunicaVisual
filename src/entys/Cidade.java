package entys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long idCidade;
	private String nome;
	@ManyToOne
	private Estado estado = new Estado();
	
	public Cidade(){}
	
	public Cidade(long idCidade, String nome, Estado estado) {
		super();
		this.idCidade = idCidade;
		this.nome = nome;
		this.estado = estado;
	}
	public long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
