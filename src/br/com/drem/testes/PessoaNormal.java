package br.com.drem.testes;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.persistence.EntityManager;

import br.com.drem.entity.Cidade;
import br.com.drem.entity.Pessoa;
import br.com.drem.util.JPAUtil;

public class PessoaNormal {

	public static void main(String[] args) {
		Pessoa pes = new Pessoa();
		Cidade cidade = new Cidade();
		cidade.setIdCidade(7);
		
		pes.setNome("Pedro");
		pes.setEndereco("608 Norte");
		pes.setCep("7700003");
		//pes.setCidade(cidade);
		EntityManager em3 = JPAUtil.getEntityManager();
		em3.getTransaction().begin();
		em3.persist(pes);
		em3.getTransaction().commit();
		em3.close();

	}

}
