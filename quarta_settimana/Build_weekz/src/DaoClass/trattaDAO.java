package DaoClass;

import javax.persistence.EntityManager;

import Util.util;
import Veicoli.tratta;
import Veicoli.veicolo;

public class trattaDAO {

	public void saveTratta(tratta t) {
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Abbonamento aggiunto al DB");
		}
}

