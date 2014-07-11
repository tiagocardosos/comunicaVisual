package br.com.drem.util;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	/* para garantir que vou fazer essa conexãoo apenas uma vez no meu sistema */
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("comunicaVisual");
	
	/* metodo que retorna  a criação da entidade manager */
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

}
