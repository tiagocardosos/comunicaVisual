/**
 * 
 */
package br.com.drem.utilitario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.drem.entity.Estado;
import br.com.drem.util.JPAUtil;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
@ManagedBean
@RequestScoped
public class BbEstado implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Estado>estados;

	 public List<Estado> getEstados() {
		 if(estados == null) {
			 estados = new ArrayList<Estado>();
			 EntityManager em = JPAUtil.getEntityManager();
			 Query q = em.createQuery("select a from Estado a",
					 Estado.class);
			 this.estados = q.getResultList();
		 }
	    	return estados;
	    
		 
	 }

	public void setEstado(List<Estado> estados) {
		this.estados = estados;
	}
	 
	 

}
