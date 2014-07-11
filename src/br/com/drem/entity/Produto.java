package br.com.drem.entity;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String nome;
	
	private String especificacao;
	
	private String precoDeFornecedor;
	
	private String precoDeVenda;
	
	private String tamanho;

	public Produto(String nome, String especificacao, String precoDeFornecedor,
			String precoDeVenda, String tamanho) {
		super();
		this.nome = nome;
		this.especificacao = especificacao;
		this.precoDeFornecedor = precoDeFornecedor;
		this.precoDeVenda = precoDeVenda;
		this.tamanho = tamanho;
	}

	public Produto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getPrecoDeFornecedor() {
		return precoDeFornecedor;
	}

	public void setPrecoDeFornecedor(String precoDeFornecedor) {
		this.precoDeFornecedor = precoDeFornecedor;
	}

	public String getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(String precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
	
}
