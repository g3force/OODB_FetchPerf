package edu.dhbw.oodb.jpql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPQL {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		EntityManager em = null;
		while (!(str = bufferedReader.readLine()).equals("")) {
			try {
				em = EMFactory.getEntityManager();
				Query query = em.createQuery(str);
				//List results = query.setHint("toplink.refresh","true").getResultList();
				List results = query.getResultList();
				for (Object obj: results) {
					if (obj instanceof Object[]) {
						Object[] objs = (Object[])obj;
						int anzahl = objs.length;
						for (int i=0; i<anzahl;i++) {
							System.out.print(objs[i]+" ");
						}
					} else {
						System.out.print(obj);
					}
					System.out.println();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				em.close();
			}
		}
			
	}

}
