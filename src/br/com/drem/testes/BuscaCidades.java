package br.com.drem.testes;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.drem.entity.Cidade;
import br.com.drem.util.*;

public class BuscaCidades {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		String consulta = "select c from Cidade c";
		TypedQuery<Cidade> query = em.createQuery(consulta, Cidade.class);
		
		List<Cidade> resultado = query.getResultList();
		
		for (Cidade cidade : resultado) {
			System.out.println(cidade.getNome());
		}
	}

}
