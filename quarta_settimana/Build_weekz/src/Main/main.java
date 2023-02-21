package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DaoClass.utenteDAO;
import DaoInterfacess.UtenteDao;
import Utente.registrato;
import Utente.utente;

public class main {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Build_week");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UtenteDao utente1 = new utenteDAO();
		utente1.setId(123);
		utente1.StatoRegi(registrato.REGISTRATO);
		
		UtenteDao utente2 = new utenteDAO();
		utente2.setId(987);
		utente2.StatoRegi(registrato.NON_REGISTRATO);
		
		CreaUtenteDB(123);
		CreaUtenteDB(987);
	}
	
	public static void CreaUtenteDB(int id) {
		try {
			em.getTransaction().begin();
			em.persist(id);
			em.getTransaction().commit();
		}
		finally {
			
		}
		System.out.println("Utente aggiunto al DB");
	}
	
}
