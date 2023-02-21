package Main;

import DaoClass.utenteDAO;
import Biglietteria.utente;



public class main {

	public static void main(String[] args) {
		
		utente utente1 = new utente();
		utente1.setNome("Dino");
		utente1.setCognome("Plutonuo");
		
		utenteDAO utente1DAO = new utenteDAO();
		utente1DAO.CreaUtenteDB(utente1);
	}		
}
