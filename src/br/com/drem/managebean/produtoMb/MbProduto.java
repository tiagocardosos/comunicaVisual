package br.com.drem.managebean.produtoMb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.drem.dao.ProdutoDao;
import br.com.drem.entity.Produto;
import br.com.drem.managebean.produtoMb.rn.RegraNegocioProduto;
import br.com.drem.util.JPAUtil;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean(name = "mbProduto")
public class MbProduto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private ProdutoDao produtoDao;
	private List<Produto> resultado;

	public MbProduto() {
		this.produtoDao = new ProdutoDao();
		this.produto = new Produto();
	}

	public void setResultado(List<Produto> resultado) {
		this.resultado = resultado;
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

	public String novo() {
		RegraNegocioProduto.limpProduto();
		return "pgproduto";
	}
	
	public String salvar(){
		RegraNegocioProduto.salvar(produto);
		return"pgtbproduto" + "?faces-redirect=true";
	}
	
	public String excluir(){
		RegraNegocioProduto.excluir(produto);
		return "pgtbproduto" + "?faces-redirect=true";
	}
	
	public String direcionarAlteracao() {
		return "pgproduto";
	}


	public List<Produto> getResultado() {
		if(resultado == null){
			//resultado = new ArrayList<Produto>();
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select a from Produto a", Produto.class);
			this.resultado = q.getResultList();
			em.close();	
		}
		return resultado;
	}
	public List<Produto> filtroPersonalizado() throws IOException {
		EntityManager em = JPAUtil.getEntityManager();
		String consulta = "select p from Produto p where p.nomeProduto = :nome";
		TypedQuery<Produto> query = em.createQuery(consulta, Produto.class);
		query.setParameter("nome", produto.getNomeProduto());
		this.resultado = query.getResultList();
		//FacesContext.getCurrentInstance().getExternalContext().redirect("pgtbproduto.xhtml");
		// + "pgtbproduto?faces-redirect=true"
		em.close();
		return resultado;
	} 
}
