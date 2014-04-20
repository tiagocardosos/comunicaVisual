package testeUnitario;

import javax.persistence.EntityManager;

import util.JPAUtil;
import entys.PessoaFisica;

public class TestePessoaFisica {

	public static void main(String[] args) {
	
		PessoaFisica pessoaFisica = new PessoaFisica();
	
		pessoaFisica.setNome("Nova pessoa fisica");
		pessoaFisica.setEndereco("697 sul");
		pessoaFisica.setCep("77000001");
		pessoaFisica.setCpf("890766");
		pessoaFisica.setMatricula("3fc2012");
		pessoaFisica.setRg("897654");

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoaFisica);
		em.getTransaction().commit();
		em.close();
	}

}
