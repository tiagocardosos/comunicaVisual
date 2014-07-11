package br.com.drem.entity;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idPais;
	@Column(name="nome")
	private String nome;
	@Column(name="sigla")
	private String sigla;
	
	@OneToMany(mappedBy="pais")
	List<Estado>estado;
	
	/* construtores de Pais */
	
	public Pais(){}
	
	public Pais(long idPais, String nome, String sigla) {
		super();
		this.idPais = idPais;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public Pais( String nome, String sigla) {
		super();
		this.idPais = getIdPais();
		this.nome = nome;
		this.sigla = sigla;
	}
	
	/* Fim dos construtores */


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

	public List<Estado> getEstado() {
		if(estado == null) {
			estado = new ArrayList<Estado>();
		}
		return estado;
	}

	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	

}
