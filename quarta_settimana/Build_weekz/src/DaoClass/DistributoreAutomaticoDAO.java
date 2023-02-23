package DaoClass;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Biglietteria.DistributoreAutomatico;
import Biglietteria.abbonamenti;
import Biglietteria.biglietto;
import Util.util;



public class DistributoreAutomaticoDAO {
	
	static EntityManager em = util.getEntityManagerFactory().createEntityManager();
	
	public void addTicketDispenser(DistributoreAutomatico d) {
			
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
			
			System.out.println("Distributore aggiunto al DB");
	}
	
	
	public int getTicketNumberByDate(Date periodo, DistributoreAutomatico d) {
		
		Set<biglietto> lista = d.getBiglietti();
		int contatore = 0;
		for(biglietto b : lista)
			if(b.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
	
	public int getSubNumberByDate(Date periodo, DistributoreAutomatico d) {
		
		Set<abbonamenti> lista = d.getAbbonamenti();
		int contatore = 0;
		for(abbonamenti a : lista)
			if(a.getData_rilascio().compareTo(periodo) < 0) contatore++;
		return contatore;
	}
	
	
	public DistributoreAutomatico getDistributoreByID(int id) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT x FROM DistributoreAutomatico x WHERE id = " + id);
		return (DistributoreAutomatico) q.getSingleResult();
	}
	
}

