package entys;
/*
 * Autor: André Martins 
 * contato: andremartins@outlook.com.br
 * tecnologias sendo utilizadas: jpa, hibernate, java e postgresql 9
*/

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*  a anotacao Inheritance é utilizada para criacao de herança dentro de nossa jpa
 *  com ela é possivel criar as tabelas com heranca dentro do banco de dados
 *  para criarmos precisamos de uma strategy que no caso aqui foi utilizada
 *  o Joined que vai criar as tres entidades no banco de dados e em nosso caso
 *  é mais indicado
*/
@Inheritance(strategy = InheritanceType.JOINED)
/* definimos a entidade */
@Entity

/* definimos o nome da tabela e o schema do bando de dados no caso do
 * postgresql foi necessário a utilizacao dessa anotacao pois até o 
 * momento nao foi possivel denifir isso no proprio persistence.xml
 * isso se torna uma desvantágem em relacao a manutenabilidade
*/

@Table(name = "pessoa", schema = "dremcom_drem")
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
