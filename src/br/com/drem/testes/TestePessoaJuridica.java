package br.com.drem.testes;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.persistence.EntityManager;

import br.com.drem.entity.Cidade;
import br.com.drem.entity.Estado;
import br.com.drem.entity.Pais;
import br.com.drem.entity.PessoaFisica;
import br.com.drem.entity.PessoaJuridica;
import br.com.drem.util.JPAUtil;

public class TestePessoaJuridica {
	public static void main(String[] args) {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		Pais pais = new Pais();
		pais.setNome("Qualquer");
		pais.setSigla("ZZ");
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
		
		
		Estado estado = new Estado();
		estado.setPais(pais);
		estado.setNome("Estado");
		estado.setUf("ZA");
		EntityManager em1 = JPAUtil.getEntityManager();
		em1.getTransaction().begin();
		em1.persist(estado);
		em1.getTransaction().commit();
		em1.close();
		
		Cidade cidade = new Cidade();
		cidade.setEstado(estado);
		cidade.setNome("ZUUU");
		EntityManager em2 = JPAUtil.getEntityManager();
		em2.getTransaction().begin();
		em2.persist(cidade);
		em2.getTransaction().commit();
		em2.close();
		
		pessoaJuridica.setNome("Nova pessoa fisica");
		pessoaJuridica.setEndereco("697 sul");
		pessoaJuridica.setCep("77000001");
		pessoaJuridica.setCnpj("123456");
		pessoaJuridica.setInscricaoEstadual("12345");
		pessoaJuridica.setMatricula("fc20891");
		pessoaJuridica.setRazaoSocial("Martins e Silva ltda");
		//pessoaJuridica.setCidade(cidade);
		
		EntityManager em3 = JPAUtil.getEntityManager();
		em3.getTransaction().begin();
		em3.persist(pessoaJuridica);
		em3.getTransaction().commit();
		em3.close();
	}

}
