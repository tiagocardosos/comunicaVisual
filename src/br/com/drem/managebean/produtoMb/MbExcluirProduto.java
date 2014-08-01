package br.com.drem.managebean.produtoMb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drem.entity.Produto;
import br.com.drem.managebean.produtoMb.rn.RegraNegocioProduto;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean
@ViewScoped
public class MbExcluirProduto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Produto produto;
	
	public MbExcluirProduto(){
		this.produto = new Produto();
	}
	public String excluir(){
		RegraNegocioProduto.excluir(produto);
		return "pgtbproduto" + "?faces-redirect=true";
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
