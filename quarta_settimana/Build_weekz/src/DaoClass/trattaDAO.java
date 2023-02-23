package DaoClass;

import javax.persistence.EntityManager;

import Util.util;
import Veicoli.tratta;
import Veicoli.veicolo;

public class trattaDAO {

	public void addRoute(tratta t) {
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
	
	
	public void getRouteTime(veicolo v, tratta t, int orarioPartenza, int orarioArrivo) {
		t.setOrarioPartenza(orarioPartenza);
		t.setOrarioArrivo(orarioArrivo);
		int orarioComplessivo = orarioArrivo - orarioPartenza;
		t.setTempo_tratta(orarioComplessivo);
		v.setTratta(t);
		System.out.println("il tempo percorso dal veicolo è: " + orarioComplessivo); 
		t.setTratta_completata(t.getTratta_completata() + 1);
	}
}

