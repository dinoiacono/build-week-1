package DaoClass;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import Biglietteria.biglietto;
import Util.util;
import Veicoli.tratta;
import Veicoli.veicolo;

public class veicoloDAO {

	public void addVehicle(veicolo v) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
		
		System.out.println("Veicolo creato nel DB");
	}
	
	public int getTicketNumberValidatedByDate(veicolo v, Date date) {
		Set<biglietto> lista = null;
		for(biglietto b : v.getBiglietti()) {
			if(b.getData_vidimazione().compareTo(date)<0)lista.add(b);
		}
		return lista.size();
	}
	
	
}
