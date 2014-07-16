package br.com.drem.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="contato")
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idContato;
	private String telefoneOne;
	private String telefoneTwo;
	
	String email;

	public String getTelefoneOne() {
		return telefoneOne;
	}

	public void setTelefoneOne(String telefoneOne) {
		this.telefoneOne = telefoneOne;
	}

	public String getTelefoneTwo() {
		return telefoneTwo;
	}

	public void setTelefoneTwo(String telefoneTwo) {
		this.telefoneTwo = telefoneTwo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	
}
