package DaoClass;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import Biglietteria.DistributoreAutomatico;
import Biglietteria.abbonamenti;
import Biglietteria.biglietto;
import Util.util;

public class DistributoreAutomaticoDAO {

	
	public void saveMacchinetta(DistributoreAutomatico d) {
			
			EntityManager em = util.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.persist(d);
				em.getTransaction().commit();
			}
			catch (Exception ex) {
	            em.getTransaction().rollback(); 

			}
			finally {
				em.close();
			}
			
			System.out.println("Macchinetta aggiunta al DB");
	}
	
	
	public int contaBiglietti(Date periodo, DistributoreAutomatico d) {
		
		Set<biglietto> lista = d.getBiglietti();
		int contatore = 0;
		for(biglietto b : lista)
			if(b.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
	
	public int contaAbbonamenti(Date periodo, DistributoreAutomatico d) {
		
		Set<abbonamenti> lista = d.getAbbonamenti();
		int contatore = 0;
		for(abbonamenti a : lista)
			if(a.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
}

