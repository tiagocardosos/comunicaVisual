package br.com.drem.testes;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.drem.dao.CidadeDao;
import br.com.drem.entity.Cidade;
import br.com.drem.entity.PessoaFisica;
import br.com.drem.util.JPAUtil;

public class TestePessoaFisica {

	public static void main(String[] args) {
		ArrayList<Cidade> cidade = new ArrayList<Cidade>();
		CidadeDao cidDao = new CidadeDao();
		cidade = cidDao.buscarCidade("Palmas");
		
		/*for (Cidade aux : cidade) {
			System.out.println(aux.getIdCidade() + " - "+ aux.getNome() + " - "+ aux.getEstado().getNome());
		}*/
		
		
		PessoaFisica pessoaFisica = new PessoaFisica();
	
		pessoaFisica.setNome("Lulu santos");
		pessoaFisica.setEndereco("Copa cabana");
		pessoaFisica.setCep("7700000");
		pessoaFisica.setCpf("1010101010");
		pessoaFisica.setObs("esse cara canta de mais e toca de mais");
		pessoaFisica.setCidade(cidade.get(1));
		pessoaFisica.setMatricula("show");
		pessoaFisica.setRg("1010110");

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(pessoaFisica);
		em.getTransaction().commit();
		em.close();
	}

}
