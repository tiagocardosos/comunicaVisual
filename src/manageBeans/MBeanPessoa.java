package manageBeans;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.*;
import entys.Pessoa;
import daos.PessoaDao;
@ManagedBean
public class MBeanPessoa {
	
	Pessoa pes = new Pessoa();
	PessoaDao pesDao = new PessoaDao();

/*	public String salvar(){
		pesDao.salvar(pes);
		return pes.getNome();
	}*/
	
	
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
