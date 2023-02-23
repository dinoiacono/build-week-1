package DaoClass;

import javax.persistence.EntityManager;
import Biglietteria.utente;
import Util.util;

public class utenteDAO {
	
	public void addUser(utente u) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		System.out.println("Utente aggiunto al DB");
	
	}
}
