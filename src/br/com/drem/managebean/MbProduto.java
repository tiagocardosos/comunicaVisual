package br.com.drem.managebean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drem.dao.ProdutoDao;
import br.com.drem.entity.Produto;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean(name="mbProduto")
@ViewScoped
public class MbProduto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private ProdutoDao produtoDao;
	
	public MbProduto(){
		this.produto = new Produto();
		this.produtoDao = new ProdutoDao();
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public String salvar(){
		produtoDao.salvar(produto);
		return "index";
	}

}
