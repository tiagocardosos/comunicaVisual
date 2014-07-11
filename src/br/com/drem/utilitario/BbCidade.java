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
import javax.persistence.TypedQuery;

import br.com.drem.entity.Cidade;
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
public class BbCidade implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Cidade>cidade;
	private Estado estado;
	
	public BbCidade(){
		this.estado = new Estado();
		cidade = new ArrayList<Cidade>();
	}
	
	 public List<Cidade> getCidade() {
			 EntityManager em = JPAUtil.getEntityManager();
			 String consulta = "select c from Cidade c where c.estado.idEstado = :nome";
			 TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class);
			 query.setParameter("nome", estado.getIdEstado());
			 this.cidade = query.getResultList();
	    	 //em.close();
		 return cidade;
	 }

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}
}
