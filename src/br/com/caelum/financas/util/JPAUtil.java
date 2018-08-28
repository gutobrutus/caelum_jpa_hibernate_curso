package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlefinancas");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void closeFactory() {
		if (emf != null) {
			emf.close();
		}
	}
}
