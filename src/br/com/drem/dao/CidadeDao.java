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
import javax.persistence.TypedQuery;

import br.com.drem.entity.Cidade;
import br.com.drem.util.JPAUtil;

public class CidadeDao {
	
	private ArrayList<Cidade>cid = null;
	
	/**Metodo para buscar uma cidade com paramentro em String*/
	public ArrayList<Cidade> buscarCidade(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "select a from Cidade a where a.nome = :nome";

		TypedQuery<Cidade> query = em.createQuery(jpql, Cidade.class);

		query.setParameter("nome", nome);
		
		List<Cidade> result = query.getResultList();
		cid = new ArrayList<Cidade>();
		
		for (Cidade aux : result) {
			cid.add(aux);
		}
		return cid;
		
	}

	/*public String buscar(String nome) {

		EntityManager em = JPAUtil.getEntityManager();
		String consulta = "select p from Cidade p where p.nome = '" + nome
				+ "'";
		TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class);
		//Cidade cidade = query.getSingleResult();
		Cidade cidade = query.getSingleResult();
		
		//System.out.println(" O nome da Pessoa é = " + cidade.getNome());

		em.close();
		
		return cidade.getNome();

		// List<Pessoa> pes = q.getResultList();
		// em.close();

		
		 * for (Pessoa aux : pes) { System.out.println(aux.getNome()); }
		 

	}*/

	public ArrayList<Cidade> getCid() {
		return cid;
	}

	public void setCid(ArrayList<Cidade> cid) {
		this.cid = cid;
	}

	/*
	 * public static void main(String[] args) { CidadeDao cidDao = new
	 * CidadeDao(); Cidade cidade = new Cidade(); cidade.setNome("Gurupi");
	 * cidDao.buscarCidade(cidade); }
	 */
	
	
	/*
	public static void main(String[] args) {
		CidadeDao cdDao = new CidadeDao();
		cdDao.buscarCidade("Palmas");
	}
*/

}
