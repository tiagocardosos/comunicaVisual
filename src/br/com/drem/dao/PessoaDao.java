package br.com.drem.dao;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import br.com.drem.entity.Pessoa;
import br.com.drem.util.JPAUtil;

public class PessoaDao {
	List<Pessoa>pessoa;
	ArrayList<Pessoa> pes;
	Pessoa usuario;
	
	public PessoaDao(){
		//this.usuario = new Pessoa();
	}
	
	//Pessoa pessoa = null;
	/**Salvar uma pessoa*/
	public String salvar(Pessoa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
		String s =  pessoa.getNome();
		return s;
		
	}
	/**Buscar pessoa por id*/
	public Pessoa buscaPessoa(long id){
	    EntityManager em = JPAUtil.getEntityManager();
	    usuario = em.find(Pessoa.class, id);
	    em.close();
	    return usuario;
	}
	
	/** excluir uma pessoa*/
	public String excluir(Pessoa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		em.close();
		String s =  pessoa.getNome();
		return s;
		
	}
	
	/** atualizar uma pessoa*/
	public String atualizar(Pessoa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		em.close();
		String s =  pessoa.getNome();
		return s;
		
	}
	
	/**buscar todas as pessoas*/
	 public List<Pessoa> getPessoas() {
	    	EntityManager em = JPAUtil.getEntityManager();
	    	Query q = em.createQuery("select a from Pessoa a",
	    	                Pessoa.class);
	    	this.pessoa = q.getResultList();
	    	em.close();
	    	return pessoa;
	    }
	
	/* buscar apenas um registro em caso do registro null ou n encontrado é gerdao um exceção */
	
	 /**Busca de um lista com parametro*/
	 public ArrayList<Pessoa> buscarPessoa(String nome) {
			EntityManager em = JPAUtil.getEntityManager();
			String jpql = "select a from Pessoa a where a.nome = :nome";
			TypedQuery<Pessoa> query = em.createQuery(jpql, Pessoa.class);
			query.setParameter("nome", nome);
			List<Pessoa> result = query.getResultList();
			pes = new ArrayList<Pessoa>();
			for (Pessoa aux : result) {
				pes.add(aux);
			}
			return pes;
			
		}
	
	/**Gethers and sethers de pessoa*/
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
}
