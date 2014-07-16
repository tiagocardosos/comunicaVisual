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
		pais.setNome("Brasil");
		pais.setSigla("Br");
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
		
		
		
	}

}
