package DaoClass;

import javax.persistence.EntityManager;

import Util.util;
import Veicoli.tratta;

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
	
	public void calcolMediaTratta(int tempo_tratta) {
		int punto_partenza = 0;
		int punto_destinazione = 0;
		int media = (punto_partenza + punto_destinazione) / 2;
		
		System.out.println("il tempio medio tra le tratte è di: " + media);
	}
}

