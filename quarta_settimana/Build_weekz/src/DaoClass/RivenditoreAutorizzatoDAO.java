package DaoClass;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import Biglietteria.RivenditoreAutorizzato;
import Biglietteria.abbonamenti;
import Biglietteria.biglietto;
import Util.util;

public class RivenditoreAutorizzatoDAO {

	public void addReseller(RivenditoreAutorizzato r) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Rivenditore aggiunto al DB");
}

	/*
	 * <h1>RITORNA NUMERO BIGLIETTI!</h1>
	 * 
	 * @return Ritorna il numero di biglietti venduti dal rivenditore
	 */
	public int getTicketNumberByReseller(Date periodo, RivenditoreAutorizzato r) {
		
		Set<biglietto> lista = r.getBiglietti();
		int contatore = 0;
		for(biglietto b : lista)
			if(b.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
	
	/*
	 * <h1>RITORNA NUMERO ABBONAMENTO!</h1>
	 * 
	 * @return Ritorna il numero di abbonamenti venduti dal rivenditore
	 */
	public int getSubscriptionNumberByReseller(Date periodo, RivenditoreAutorizzato r) {
		
		Set<abbonamenti> lista = r.getAbbonamenti();
		int contatore = 0;
		for(abbonamenti a : lista)
			if(a.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
}
