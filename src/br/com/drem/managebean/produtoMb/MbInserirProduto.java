package br.com.drem.managebean.produtoMb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.drem.entity.Produto;
import br.com.drem.managebean.produtoMb.rn.RegraNegocioProduto;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean
public class MbInserirProduto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Produto produto;
	
	public MbInserirProduto(){
		this.produto = new Produto();
	}

	public Produto getProduto() {
		if(produto == null){
			this.produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvar(){
		RegraNegocioProduto.salvar(produto);
		return"pgtbproduto";
	}
	

}
