package DaoClass;

import javax.persistence.EntityManager;
import Biglietteria.biglietto;
import Util.util;

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
}
