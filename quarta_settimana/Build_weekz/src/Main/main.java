package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DaoClass.utenteDAO;
import DaoInterfacess.UtenteDao;
import Utente.registrato;
import Utente.utente;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		utente utente1 = new utente();
		utente1.setNome("Dino");
		utente1.setCognome("Plutonuo");
		utente1.setRegistrato(registrato.REGISTRATO);
		
		utenteDAO utente1DAO = new utenteDAO();
		utente1DAO.CreaUtenteDB(utente1);
	}		
}
