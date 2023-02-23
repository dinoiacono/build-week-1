package Main;

// Custom Import
import DaoClass.*;
import Util.*;
import Veicoli.*;
import Biglietteria.*;

import java.util.*;
import javax.persistence.*;


public class main {
	

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			
//			System.out.println("Benvenuto nel pannello amministazione");
//			
//			
//			
//			
//		}

		
		utente u1 = new utente();
		u1.setNome("Mario");
		u1.setCognome("Rossi");
		
		utente u2 = new utente();
		u1.setNome("Luigi");
		u1.setCognome("Verdi");

		
		DistributoreAutomatico d1 = new DistributoreAutomatico();
		d1.setStato(Status.ATTIVO);

		
		biglietto t1 = new biglietto();
		t1.generateTicket(new GregorianCalendar (2023, 02, 12), d1);
		
		


		tessera tessera2 = new tessera();
		tessera2.generaTessera(new GregorianCalendar (2023, 02, 12), u2);
		
		abbonamenti a1 = new abbonamenti();
	
		
		
		RivenditoreAutorizzato r1 = new RivenditoreAutorizzato();
		r1.setNome("L'edicola di Gianni che batte i panni");
	
		
		utenteDAO u1DAO = new utenteDAO();
		u1DAO.addUser(u1);
		utenteDAO u2DAO = new utenteDAO();
		u2DAO.addUser(u2);
		DistributoreAutomaticoDAO m1 = new DistributoreAutomaticoDAO();
		m1.addTicketDispenser(d1);
		bigliettoDAO t1DAO = new bigliettoDAO();
		t1DAO.addTicket(t1);
		RivenditoreAutorizzatoDAO r1DAO = new RivenditoreAutorizzatoDAO(); 
		r1DAO.addReseller(r1);
		
		
		tratta tr1 = new tratta();
		tr1.creaTratta("Roma Termini", "Milano Centrale", 12, 18);
		tr1.setTempoMedioTratta(6);
		tr1.setTratta_completata(false);
		

		trattaDAO tr1DAO = new trattaDAO();
		tr1DAO.addRoute(tr1);
		
		
		
		veicolo v1 = new veicolo();
		v1.creaVeicolo(tipoveicolo.TRAM, stato.SERVIZIO);
		
		veicoloDAO v1DAO = new veicoloDAO();
		v1DAO.addVehicle(v1);
		
		

		
//		tr1DAO.getTrattaByID(0);
//		
////		tr1DAO.getRouteTime(v1, tr1, 0, 0);
//		
//		
		
		

		
	}
	
	
}
