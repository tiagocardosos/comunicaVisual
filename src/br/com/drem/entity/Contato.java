package br.com.drem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*@Entity(name="contato")*/
public class Contato {
	
	@Id @GeneratedValue
	private String telefone;
	
	String email;

	public Contato(String telefone, String email) {
		super();
		this.telefone = telefone;
		this.email = email;
	}
	
	public Contato() {}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
