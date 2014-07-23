package br.com.drem.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.context.RequestContext;

import br.com.drem.dao.ProdutoDao;
import br.com.drem.entity.Produto;
import br.com.drem.util.JPAUtil;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean(name="mbProduto")
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
		if(produto.getIdProduto() == null || produto.getIdProduto() == 0 ){
			produtoDao.salvar(produto);
			//FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserção de produtos", "inserido com sucesso.");
			//RequestContext.getCurrentInstance().showMessageInDialog(message);
		} else {
			produtoDao.alterar(produto);
			//FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração de produtos", "Alterado com sucesso.");
			//RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return "pgtbproduto";	
	}
	public String novo(){
		return "pgproduto";
	}
	public String direcionarAlteracao(){
		return "pgproduto";
	}
}
