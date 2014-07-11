package br.com.drem.dao;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */

/*import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.drem.entity.Cidade;
import br.com.drem.util.JPAUtil;*/

public class ArquivoDeBusca {

	public static void main(String[] args) {

		/**
		 * metodo para buscar todos os elementos de uma tabela sem
		 * relacionamento
		 */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select c from Cidade c"; TypedQuery<Cidade> query =
		 * em.createQuery(consulta, Cidade.class);
		 * 
		 * List<Cidade> resultado = query.getResultList();
		 * 
		 * for (Cidade cidade : resultado) {
		 * System.out.println(cidade.getNome()); }
		 */
		/*************************************************************************************************/
		/**
		 * Metodo para para buscar um nome de uma entidade a partir de um
		 * parametro colocado na query
		 */
		/** entrada de dados com parametros */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select c from Cidade c where c.nome = :nome"; TypedQuery<Cidade>
		 * query = em.createQuery(consulta, Cidade.class);
		 * query.setParameter("nome", "Palmas");
		 * 
		 * List<Cidade> resultado = query.getResultList();
		 * 
		 * for (Cidade cidade : resultado) { System.out.println(cidade.getNome()
		 * + cidade.getEstado().getNome()); }
		 */

		/*************************************************************************************************/
		/***
		 * Busca com parametros em uma tabela apenas sem relacionamento
		 */
		/*
		 * String aux = JOptionPane.showInputDialog(null,"digite a busca");
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select c from Cidade c where c.nome = :nome"; TypedQuery<Cidade>
		 * query = em.createQuery(consulta, Cidade.class);
		 * query.setParameter("nome", aux); List<Cidade> resultado =
		 * query.getResultList(); for (Cidade cidade : resultado) {
		 * System.out.println(cidade.getNome() + " - "+
		 * cidade.getEstado().getNome()); em.close(); }
		 */
		/*************************************************************************************************/

		/** Consultas ordenando por nome */

		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select c from Cidade c order by c.nome"; TypedQuery<Cidade> query =
		 * em.createQuery(consulta, Cidade.class);
		 * 
		 * List<Cidade> resultado = query.getResultList(); for (Cidade cidade :
		 * resultado) { System.out.println(cidade.getNome() + " - "+
		 * cidade.getEstado().getNome()); } em.close();
		 */
		/*************************************************************************************************/
		/** Busca passando por três objetos que tenham relacionamento */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select a from Cidade a where a.idCidade = :nome"; TypedQuery<Cidade>
		 * query = em.createQuery(consulta, Cidade.class);
		 * query.setParameter("nome", 90L); List<Cidade> resultado =
		 * query.getResultList(); for (Cidade aux : resultado) {
		 * System.out.println(aux.getNome() + aux.getEstado().getNome() +
		 * aux.getEstado().getPais().getNome());
		 * 
		 * }
		 */

		/*************************************************************************************************/
		/** Pegando o numero de registro de uma entidade */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "SELECT COUNT(a) FROM Cidade a"; TypedQuery<Number> query =
		 * em.createQuery(consulta, Number.class);
		 * 
		 * Number result = query.getSingleResult(); System.out.println(result);
		 */

		/*************************************************************************************************/
		/** Pegando o maior e menor de uma entidade */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "SELECT max(a.nome), min(a.nome) FROM Cidade a"; TypedQuery<Object[]>
		 * query = em.createQuery(consulta, Object[].class); Object[] result =
		 * query.getSingleResult(); System.out.println("Menor " + result[0] +
		 * " Maior " + result[1]);
		 */
		/*************************************************************************************************/
		/** Pegando apenas as três primeiras letras de um campo em uma tabela */
		/*
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "SELECT SUBSTRING(p.nome, 1, 3) " +
		 * " FROM Cidade p where p.nome = 'Gurupi'"; TypedQuery<String> query =
		 * em.createQuery(consulta, String.class); String result =
		 * query.getSingleResult(); System.out.println(result);
		 */
		/*************************************************************************************************/
		/**
		 * Encontrar determinado valor que esteja dentro de uma tupla ou seja
		 * que contenha dentro de um nome por exemplo Gu que tem na cidade
		 * Gurupi
		 */
		/*
		 * String nome = JOptionPane.showInputDialog(null,"digite um nome");
		 * EntityManager em = JPAUtil.getEntityManager(); String consulta =
		 * "select p from Cidade p where p.nome like :nome"; TypedQuery<Cidade>
		 * query = em.createQuery(consulta, Cidade.class);
		 * query.setParameter("nome", "%" + nome + "%"); List<Cidade> result =
		 * query.getResultList(); for (Cidade aux: result) {
		 * System.out.println("o nome encontrado foi = " + aux.getNome()); }
		 */

	}

}
