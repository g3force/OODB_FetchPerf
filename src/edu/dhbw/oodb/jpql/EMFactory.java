package edu.dhbw.oodb.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {

	private static EntityManagerFactory emf = null;
	
	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("jpa");
		}
		
		try {
			EntityManager em = emf.createEntityManager();
			return em;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
