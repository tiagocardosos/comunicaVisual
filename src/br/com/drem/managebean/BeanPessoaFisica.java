package br.com.drem.managebean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.drem.dao.PessoaDao;
import br.com.drem.entity.PessoaFisica;

@ManagedBean(name="fisicaBean")
public class BeanPessoaFisica {
	
	PessoaFisica pessoaFisica;
	PessoaDao pesDao;
	private final String SUCESSO = "Operação realizada com sucesso";
	private final String ERRO = "Ops! Ocorreu um erro inesperado";
	
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

	public String salvar(){
		pesDao.salvar(pessoaFisica);
		return null;
	}
	
	
	public PessoaDao getPesDao() {
		if(pesDao == null){
			pesDao = new PessoaDao();
		}
		return pesDao;
	}
	
	public PessoaFisica getPessoaFisica() {
		if(pessoaFisica == null){
			pessoaFisica = new PessoaFisica();
		}
		return pessoaFisica;
	}


	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}


	public void setPesDao(PessoaDao pesDao) {
		this.pesDao = pesDao;
	}

}
