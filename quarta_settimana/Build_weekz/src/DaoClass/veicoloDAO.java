package DaoClass;

import java.util.Date;
import javax.persistence.EntityManager;
import Util.util;
import Veicoli.veicolo;

public class veicoloDAO {

	public void creaVeicolo(veicolo v) {
		
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
	
	public void calolcoBigliettiTimbrati(veicolo v, Date date) {
		
	}
}
