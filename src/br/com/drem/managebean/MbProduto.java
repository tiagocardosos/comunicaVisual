package br.com.drem.managebean;

import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	private List<Produto> resultado;
	private List<Produto>filtroPersonalizado;
	
	public MbProduto(){
		this.produto = new Produto();
		this.produtoDao = new ProdutoDao();
		this.produtos = new ArrayList<Produto>();
		this.resultado = new ArrayList<Produto>();
		this.filtroPersonalizado = new ArrayList<Produto>();
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public void setResultado(List<Produto> resultado) {
		this.resultado = resultado;
	}
	

	public List<Produto> getResultado() {
		return resultado;
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

	
	public void setFiltroPersonalizado(List<Produto> filtroPersonalizado) {
		this.filtroPersonalizado = filtroPersonalizado;
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
	public List<Produto> getProdutos() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Produto a",
				Produto.class);
		this.produtos = q.getResultList();
		em.close();
		return produtos;
	}
	public List<Produto> getFiltroPersonalizado() {
		if(filtroPersonalizado == null){
			filtroPersonalizado = new ArrayList<Produto>();
		}

		 EntityManager em = JPAUtil.getEntityManager();
		 String consulta = "select p from Produto p where p.nomeProduto = :nome";
		 TypedQuery<Produto> query = em.createQuery(consulta, Produto.class);
		 query.setParameter("nome", produto.getNomeProduto());
		 this.filtroPersonalizado = query.getResultList();
		 System.out.println(filtroPersonalizado.get(0).getNomeProduto());
		 return filtroPersonalizado;
	}
}
