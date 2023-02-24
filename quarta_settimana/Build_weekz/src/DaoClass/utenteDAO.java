package DaoClass;

import javax.persistence.*;
import Biglietteria.utente;
import Util.util;

public class utenteDAO {
	
	static EntityManager em = util.getEntityManagerFactory().createEntityManager();

	
	public void addUser(utente u) {
		
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
	
	public void updateUser(utente u) {
		
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		System.out.println("Utente aggiornato al DB");
	
	}
	
    public utente getUtenteByID(int id) {
    	utente u = em.find(utente.class, id);
        if (u == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        return u;
    }
	
}
