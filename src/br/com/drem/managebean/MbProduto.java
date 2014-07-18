package br.com.drem.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.drem.dao.ProdutoDao;
import br.com.drem.entity.Cidade;
import br.com.drem.entity.Produto;
import br.com.drem.util.JPAUtil;

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
	private List<Produto>produtos;
	
	public MbProduto(){
		this.produto = new Produto();
		this.produtoDao = new ProdutoDao();
		this.produtos = new ArrayList<Produto>();
	}
	
    public List<Produto> getProdutos() {
    	EntityManager em = JPAUtil.getEntityManager();
    	Query q = em.createQuery("select a from Produto a",
    	                Produto.class);
    	this.produtos = q.getResultList();
    	em.close();
    	return produtos;
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
	
	public String excluir() {
		produtoDao.excluir(produto);
		return null;
	}
	public String salvar(){
		produtoDao.salvar(produto);
		return "pgproduto";
	}


}
