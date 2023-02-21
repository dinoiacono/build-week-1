package DaoClass;

import java.util.Date;

import javax.persistence.EntityManager;
import Biglietteria.abbonamenti;
import Biglietteria.utente;
import Util.util;

public class abbonamentoDAO {
	
	public void saveAbbonamento(abbonamenti a) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
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

	public void verificaValidita(utente u, Date periodo) {
		if(u.getAbbonamento().getData_rilascio().compareTo(periodo) < 0) System.out.println("Abbonamento ancora valido");	
	}
	
}
