package br.com.drem.entity;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** a anotacao Inheritance é utilizada para criacao de herança dentro de nossa jpa
 *  com ela é possivel criar as tabelas com heranca dentro do banco de dados
 *  para criarmos precisamos de uma strategy que no caso aqui foi utilizada
 *  o Joined que vai criar as tres entidades no banco de dados e em nosso caso
 *  é mais indicado
 */
@Inheritance(strategy = InheritanceType.JOINED)
/**Definimos a entidade*/
@Entity
/**Definimos o nome da tabela*/
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**Campos da entidade*/
	@Id
	/**para o postgres é necessário a estratégia sequence para definir
	 * que será do tipo serial */
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	/**Column é definida para o nome da coluna no banco de dados*/
	@Column(name = "id")
	private Long id;
	
	/**Column é definida para o nome da coluna no banco de dados*/
	@Column(name = "nome")
	private String nome;
	
	/**Column é definida para o nome da coluna no banco de dados*/
	@Column(name = "endereco")
	private String endereco;
	
	/**Column é definida para o nome da coluna no banco de dados*/
	@Column(name = "cep")
	private String cep;
	
	/**Column é definida para o nome da coluna no banco de dados*/
	@Column(name = "observacoes")
	private String obs;
	
	/**Relacionamentos da entidade*/
	/*@ManyToOne
	private Estado estado = new Estado();
	*/
	@ManyToOne
	/**JoincColumn é definido o nome da chave estrangeira*/
	private Cidade cidade;
	
	public Pessoa(){
		this.cidade = new Cidade();
	}
	
	/* gethers and sethers */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
