package testeUnitario;

import javax.persistence.EntityManager;

import util.JPAUtil;
import entys.Pessoa;

public class TesteConexaoPostgre {
	public static void main(String[] args) {

		
		Pessoa pes = new Pessoa();
		
		pes.setNome("Andrades");
		pes.setEndereco("67 sul");
		pes.setCep("7700000");
		
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pes);
		em.getTransaction().commit();
		em.close();
		
	}
}
