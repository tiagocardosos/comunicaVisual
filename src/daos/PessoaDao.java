package daos;
import javax.persistence.EntityManager;

import entys.Pessoa;
import util.JPAUtil;

public class PessoaDao {
	
	public String salvar(Pessoa pessoa) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		em.close();
		String s =  pessoa.getNome();
		return s;
		
	}


}
