package testeUnitario;

import javax.persistence.EntityManager;

import util.JPAUtil;
import entys.PessoaFisica;
import entys.PessoaJuridica;

public class TestePessoaJuridica {
	public static void main(String[] args) {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		pessoaJuridica.setNome("Nova pessoa fisica");
		pessoaJuridica.setEndereco("697 sul");
		pessoaJuridica.setCep("77000001");
		pessoaJuridica.setCnpj("123456");
		pessoaJuridica.setInscricaoEstadual("12345");
		pessoaJuridica.setMatricula("fc20891");
		pessoaJuridica.setRazaoSocial("Martins e Silva ltda");


		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoaJuridica);
		em.getTransaction().commit();
		em.close();
	}

}
