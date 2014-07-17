package br.com.drem.entity;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idProduto;
	
	private String nomeProduto;
	
	private String especificacaoProduto;
	
	private String precoDeMetroVenda;
	
	private String medidaX;
	
	private String medidaY;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getEspecificacaoProduto() {
		return especificacaoProduto;
	}

	public void setEspecificacaoProduto(String especificacaoProduto) {
		this.especificacaoProduto = especificacaoProduto;
	}

	public String getPrecoDeMetroVenda() {
		return precoDeMetroVenda;
	}

	public void setPrecoDeMetroVenda(String precoDeMetroVenda) {
		this.precoDeMetroVenda = precoDeMetroVenda;
	}

	public String getMedidaX() {
		return medidaX;
	}

	public void setMedidaX(String medidaX) {
		this.medidaX = medidaX;
	}

	public String getMedidaY() {
		return medidaY;
	}

	public void setMedidaY(String medidaY) {
		this.medidaY = medidaY;
	}
	
	

	
}
