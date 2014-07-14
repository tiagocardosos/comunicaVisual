package br.com.drem.managebean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
public class BeanPessoaFisica {
	
	Pessoa pessoa;
	PessoaDao pesDao;
	private final String SUCESSO = "Operação realizada com sucesso";
	private final String ERRO = "Ops! Ocorreu um erro inesperado";
	private List<Estado>estados;
	private List<Cidade>cidades;
	private Estado estado;
	private Cidade cidade;
	private PessoaFisica pessoaFisica;
	private PessoaFisicaDao pessoaFisicaDao;

	
	public BeanPessoaFisica(){
		this.pessoa = new Pessoa();
		this.estados = new ArrayList<Estado>();
		this.cidades = new ArrayList<Cidade>();
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
		 EntityManager em = JPAUtil.getEntityManager();        
         Query query = em.createQuery("select c from Cidade c where c.estado = :estado");
         query.setParameter("estado", estado);
         return query.getResultList();
        // em.close();
 }
	 public String Salvar(){
		 pessoaFisicaDao.salvar(pessoaFisica);
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
	                 ERRO,
	ERRO) );}

	
	public PessoaDao getPesDao() {
		return pesDao;
	}
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setPesDao(PessoaDao pesDao) {
		this.pesDao = pesDao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
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
	
	

}
