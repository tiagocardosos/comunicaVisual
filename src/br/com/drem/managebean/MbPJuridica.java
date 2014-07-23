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

import org.primefaces.context.RequestContext;

import br.com.drem.dao.PJuridicaDao;
import br.com.drem.entity.Cidade;
import br.com.drem.entity.Contato;
import br.com.drem.entity.Estado;
import br.com.drem.entity.PessoaFisica;
import br.com.drem.entity.PessoaJuridica;
import br.com.drem.util.JPAUtil;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean(name="mbPJuridica")
public class MbPJuridica {
	
	private final String SUCESSO = "Operação realizada com sucesso";
	private final String ERRO = "Ops! Ocorreu um erro inesperado";
	private List<Estado>estados;
	private List<Cidade>cidades;
	private Estado estado;
	private Cidade cidade;
	private PessoaJuridica pessoaJuridica;
	private List<PessoaJuridica> pessoaJuridicas;
	private PJuridicaDao pessoaJuridicaDao;
	private Contato contato;
	

	public MbPJuridica(){
		this.pessoaJuridica = new PessoaJuridica();
		this.pessoaJuridicaDao = new PJuridicaDao();
		this.pessoaJuridicas = new ArrayList<PessoaJuridica>();
		this.contato = new Contato();
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

	 public List<PessoaJuridica> getPessoaJuridicas() {
		 EntityManager em = JPAUtil.getEntityManager();
		 Query q = em.createQuery("select a from PessoaJuridica a",
				 PessoaJuridica.class);
		 this.pessoaJuridicas = q.getResultList();
		 em.close();
    	return pessoaJuridicas; 
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

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PJuridicaDao getpJuridicaDao() {
		return pessoaJuridicaDao;
	}

	public void setpJuridicaDao(PJuridicaDao pJuridicaDao) {
		this.pessoaJuridicaDao = pJuridicaDao;
	}
	
	public Contato getContato() {
		if( contato==null ){
			contato = new Contato();
		}
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String excluir() {
		pessoaJuridicaDao.excluir(pessoaJuridica);
		contato = pessoaJuridica.getContato();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		contato = em.find(Contato.class, contato.getIdContato());
		em.remove(contato);
		em.getTransaction().commit();
		em.close();
		return null;
	}


	public String salvar(){
		if(pessoaJuridica.getId() == null || pessoaJuridica.getId() == 0){
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(pessoaJuridica.getContato());
			em.getTransaction().commit();
			em.close();
			pessoaJuridicaDao.salvar(pessoaJuridica);
			//FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserção de Pessoa Juridica", "inserido com sucesso.");
			//RequestContext.getCurrentInstance().showMessageInDialog(message);
		} else {
			pessoaJuridicaDao.alterar(pessoaJuridica);
		}
		
		return "pgtbpjuridica";
	}
	public String novo() {
		return "pgpjuridica";
	}
	public String direcionarAlteracao(){
		return "pgpjuridica";
	}
}
