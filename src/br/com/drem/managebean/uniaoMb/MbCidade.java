package br.com.drem.managebean.uniaoMb;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.drem.dao.CidadeDao;
import br.com.drem.entity.Cidade;
import br.com.drem.util.JPAUtil;

@ManagedBean
public class MbCidade {
	private Cidade cidade;
    private List<Cidade> cidades;
    private String aux = null;
    private String nomeDaCidade;
    CidadeDao cidadeDao = null;
    
    
    public List<Cidade> getCidades() {
    	EntityManager em = JPAUtil.getEntityManager();
    	Query q = em.createQuery("select a from Cidade a",
    	                Cidade.class);
    	this.cidades = q.getResultList();
    	em.close();
    	return cidades;
    }
    
   /* public String buscarCidade(){
    	cidadeDao = new CidadeDao();
    	cidadeDao.buscarCidade(nomeDaCidade);
    	cidadeDao.getCid().equals(cidade);
    }*/
    
    
    
    public String buscar() {
    	EntityManager em = JPAUtil.getEntityManager();
		String consulta = "select p from Cidade p where p.nome = '" + nomeDaCidade
				+ "'";
		TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class);
		//Cidade cidade = query.getSingleResult();
		Cidade cidade = query.getSingleResult();
		
		//System.out.println(" O nome da Pessoa é = " + cidade.getNome());
		em.close();
		
		if(cidade != null){
			return cidade.getNome() + cidade.getEstado() + cidade.getEstado().getPais();
		} else {
			
			return "não encontrado";
		}

		// List<Pessoa> pes = q.getResultList();
		// em.close();

		/*
		 * for (Pessoa aux : pes) { System.out.println(aux.getNome()); }
		 */

	}
    
    
	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public Cidade getCidade() {
    	if(cidade == null){
    		cidade = new Cidade();
    	} 
		return cidade;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNomeDaCidade() {
		return nomeDaCidade;
	}

	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}
	
	
}
