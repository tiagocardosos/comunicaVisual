package br.com.drem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long idEstado;
	@Column(name="nome")
	private String nome;
	@Column(name="uf")
	private String uf;
	
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidade;
	
	@ManyToOne
	private Pais pais;

	public long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Pais getPais() {
		if(pais == null) {
			pais  = new Pais();
		}
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<Cidade> getCidade() {
		return cidade;
	}
	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}
	
	

}
