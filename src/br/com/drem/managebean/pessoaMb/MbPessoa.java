package br.com.drem.managebean.pessoaMb;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.drem.dao.PessoaDao;
import br.com.drem.entity.Pessoa;
import br.com.drem.util.*;
@ManagedBean
public class MbPessoa {
	
	Pessoa pes = new Pessoa();
	PessoaDao pesDao = new PessoaDao();

/*	public String salvar(){
		pesDao.salvar(pes);
		return pes.getNome();
	}*/
	public String direciona(){
		return"destino";
	}
	
	public String redCadastroFisico(){
		return"cadastroPessoaFisica";
	}
	
	public String salvar(){
		
		/* responsável por fazer a fabrica de conexões */
		EntityManagerFactory vrEntityManegerFactory = Persistence.
				createEntityManagerFactory("dremcom_comunica");
		/* conexão em si */
		EntityManager vrEntityManeger =
				vrEntityManegerFactory.createEntityManager();
		
		
		
		return" Salvo ";		
	}
	
	
	
	public Pessoa getPes() {
		return pes;
	}
	
	public void setPes(Pessoa pes) {
		this.pes = pes;
	}
	
	public PessoaDao getPesDao() {
		return pesDao;
	}
	
	public void setPesDao(PessoaDao pesDao) {
		this.pesDao = pesDao;
	}

}
