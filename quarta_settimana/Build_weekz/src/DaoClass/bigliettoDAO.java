package DaoClass;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import Biglietteria.biglietto;
import Biglietteria.statusbiglietto;
import Biglietteria.utente;
import Util.util;
import Veicoli.veicolo;

public class bigliettoDAO {

	static EntityManager em = util.getEntityManagerFactory().createEntityManager();

	
	public void addTicket(biglietto b) {
		
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Biglietto aggiunto al DB");
	}
	
	public void updateTicket(biglietto b) {
		
		try {
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		System.out.println("Biglietto aggiornato al DB");
	
	}
	
	public void validateTicket(biglietto bigl, Date data_vidimazione) {
		if(bigl.getStatusbiglietto() == statusbiglietto.NON_TIMBRATO) {
			bigl.setData_vidimazione(data_vidimazione);
			bigl.setStatusbiglietto();
			updateTicket(bigl);

 		}else {
 			System.out.println("Biglietto già timbrato, ricompralo poveraccio!!!");
 		}
		
	}
	
	public int getAllTicketsByDate(Date data) {
		int contatore = 0;
		Query q = em.createQuery("SELECT * FROM veicoli");
		List<veicolo> mezzi = q.getResultList();
		for(veicolo v : mezzi) {
			for(biglietto b : v.getBiglietti()) {
				if(b.getData_vidimazione().compareTo(data)<0) {
					contatore++;
				}
			}
		}
		return contatore;
	}
	
    public biglietto getTicketByID(int id) {
    	biglietto b = em.find(biglietto.class, id);
        if (b == null) {
            throw new EntityNotFoundException("Can't find Artist for ID " + id);
        }
        return b;
    }
}
