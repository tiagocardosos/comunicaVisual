package br.com.drem.managebean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.drem.dao.PessoaDao;
import br.com.drem.dao.PessoaFisicaDao;
import br.com.drem.entity.Cidade;
import br.com.drem.entity.Estado;
import br.com.drem.entity.Pessoa;
import br.com.drem.entity.PessoaFisica;
import br.com.drem.util.JPAUtil;

@ManagedBean(name="fisicaBean")
@ViewScoped
public class BeanPessoaFisica {
	
	private final String SUCESSO = "Operação realizada com sucesso";
	private final String ERRO = "Ops! Ocorreu um erro inesperado";
	private List<Estado>estados;
	private List<Cidade>cidades;
	private Estado estado;
	private Cidade cidade;
	private PessoaFisica pessoaFisica;
	private PessoaFisicaDao pessoaFisicaDao;

	public BeanPessoaFisica(){
		this.pessoaFisica = new PessoaFisica();
		this.pessoaFisicaDao = new PessoaFisicaDao();
	}

	 public List<Estado> getEstados() {
		 if(estados == null) {
			 estados = new ArrayList<Estado>();
			 EntityManager em = JPAUtil.getEntityManager();
			 Query q = em.createQuery("select a from Estado a",
					 Estado.class);
			 this.estados = q.getResultList();
		 }
	    	return null; 
	 }
	 public List<Cidade> getCidades() {
		 if(cidades == null) {
			 this.cidades = new ArrayList<Cidade>();
			 EntityManager em = JPAUtil.getEntityManager();        
			 Query query = em.createQuery("select c from Cidade c where c.estado = :estado");
			 query.setParameter("estado", estado);
			 return query.getResultList();
        // em.close();
		 } 
		 return null;
 }

	
	public void mensagemSucesso(ActionEvent event) {
	    FacesContext instance = FacesContext.getCurrentInstance();
	    instance.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                SUCESSO,SUCESSO) );}
	
	public void mensagemErro(ActionEvent event) {
	    FacesContext instance = FacesContext.getCurrentInstance();
	    instance.addMessage(null,
	new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                 ERRO, ERRO) );}

	

	public Estado getEstado() {
		if (estado == null) {
			this.estados = new ArrayList<Estado>();
		}
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		if ( cidade == null){
			this.cidade = new Cidade();
		}
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}


	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
	public String salvar(){
		/*isso será trocado por cascade ;) */
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoaFisica.getContato());
		em.getTransaction().commit();
		em.close();
		
		pessoaFisicaDao.salvar(pessoaFisica);
		return "pgpfisica";
	}

}
