package DaoClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.util;
import Veicoli.tratta;
import Veicoli.veicolo;

public class trattaDAO {
	
	static EntityManager em = util.getEntityManagerFactory().createEntityManager();


	public void addRoute(tratta t) {
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
	
	
	public tratta getTrattaByID(int id) {
		try {
            em.getTransaction().begin();
            return em.find(tratta.class, id);
        } finally {
            em.close();
        }

	}
	
//	public void getRouteTime(int id) {
//		EntityManager em = util.getEntityManagerFactory().createEntityManager();
//		Query q = em.createQuery("SELECT * FROM veicoli WHERE id = " + id);
//		veicolo v = (veicolo) q.getSingleResult();
//		v.getTratta()
//		int orarioComplessivo = orarioArrivo - orarioPartenza;
//		t.setTempo_tratta(orarioComplessivo);
//		v.setTratta(t);
//		System.out.println("il tempo percorso dal veicolo è: " + orarioComplessivo); 
//		t.setTratta_completata(t.getTratta_completata() + 1);
//	}
}

