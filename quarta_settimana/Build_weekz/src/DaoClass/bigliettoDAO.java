package DaoClass;

import java.util.Set;

import javax.persistence.EntityManager;
import Biglietteria.biglietto;
import Biglietteria.statusbiglietto;
import Util.util;
import Veicoli.veicolo;

public class bigliettoDAO {

	
	public void saveBiglietto(biglietto b) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
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
	public void timbraBiglietto(veicolo veic, biglietto bigl) {
		if(bigl.getStatusbiglietto() == statusbiglietto.NON_TIMBRATO) {
			bigl.setStatusbiglietto(statusbiglietto.TIMBRATO);
			Set<biglietto> lista = veic.getBiglietti();
			lista.add(bigl);
			veic.setBiglietti(lista);
		}
		
	}
}
