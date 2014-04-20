package entys;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais {
	@Id
	private long idPais;
	private String nome;
	private String sigla;
	
	public Pais(){}
	
	public Pais(long idPais, String nome, String sigla) {
		super();
		this.idPais = idPais;
		this.nome = nome;
		this.sigla = sigla;
	}



	public long getIdPais() {
		return idPais;
	}
	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

}
