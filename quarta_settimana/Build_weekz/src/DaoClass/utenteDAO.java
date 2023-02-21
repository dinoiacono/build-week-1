package DaoClass;

import javax.persistence.EntityManager;
import DaoInterfacess.UtenteDao;
import Utente.registrato;
import Utente.utente;
import Util.util;

public class utenteDAO implements UtenteDao {

	
	
	public void CreaUtenteDB(utente u) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		System.out.println("Utente aggiunto al DB");
	
	}
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void StatoRegi(registrato registrato) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void creaUtente() {
		// TODO Auto-generated method stub
		
	}	
}
