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
import br.com.drem.entity.Pessoa;
import br.com.drem.util.JPAUtil;

public class TesteConexaoPostgre {
	public static void main(String[] args) {

		
		
		Pais pais = new Pais();
		pais.setNome("Portugal");
		pais.setSigla("PT");
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
		
		
		Estado estado = new Estado();
		estado.setPais(pais);
		estado.setNome("Goias");
		estado.setUf("GO");
		EntityManager em1 = JPAUtil.getEntityManager();
		em1.getTransaction().begin();
		em1.persist(estado);
		em1.getTransaction().commit();
		em1.close();
		
		Cidade cidade = new Cidade();
		cidade.setEstado(estado);
		cidade.setNome("Goiania");
		EntityManager em2 = JPAUtil.getEntityManager();
		em2.getTransaction().begin();
		em2.persist(cidade);
		em2.getTransaction().commit();
		em2.close();
		
		
		Pessoa pes = new Pessoa();
		pes.setNome("Andrades");
		pes.setEndereco("67 sul");
		pes.setCep("7700000");
		pes.setCidade(cidade);
		EntityManager em3 = JPAUtil.getEntityManager();
		em3.getTransaction().begin();
		em3.persist(pes);
		em3.getTransaction().commit();
		em3.close();
		
	}
}
