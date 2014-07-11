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
import javax.persistence.Query;

import br.com.drem.entity.Estado;
import br.com.drem.util.JPAUtil;

public class EstadoDao {

	private List<Estado> estado;

	/**Construtor*/
	public EstadoDao() {
		super();
		this.estado = (List<Estado>) new ArrayList<Estado>();
	}
	/**para trazer a lista de estados */
	public List<Estado> getEstados() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Estado a", Estado.class);
		this.estado = q.getResultList();
		em.close();
		return estado;
	}
	

	public List<Estado> getEstado() {
		return estado;
	}
	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	

	
}
