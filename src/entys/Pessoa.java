package entys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id  
	@GeneratedValue(strategy=GenerationType.SEQUENCE)  
	@Column(name="id")    
	private Long id;
	private String endereco;
	private String cep;
	
	
	public Long getId() {  
	    return this.id;  
	}
	private String nome;

	
	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa() {
		super();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
