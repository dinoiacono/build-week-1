package Main;

// Custom Import
import DaoClass.*;
import Util.*;
import Veicoli.*;
import Biglietteria.*;

import java.time.LocalDate;
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
		
		utenteDAO utenteDAO = new utenteDAO();
		DistributoreAutomaticoDAO distributoreDAO = new DistributoreAutomaticoDAO();
		bigliettoDAO bigliettoDAO = new bigliettoDAO();
		bigliettoDAO bigliettoDAO2 = new bigliettoDAO();
		RivenditoreAutorizzatoDAO rivenditoreDAO = new RivenditoreAutorizzatoDAO(); 
		tesseraDAO tesseraDAO = new tesseraDAO();
		abbonamentoDAO abbonamentoDAO = new abbonamentoDAO();
		veicoloDAO veicoloDAO = new veicoloDAO();



		
//		utente u1 = new utente();
//		u1.setNome("Mario");
//		u1.setCognome("Rossi");
//		
//		utente u2 = new utente();
//		u2.setNome("Luigi");
//		u2.setCognome("Verdi");

		
//		u1DAO.addUser(u1);
//		u1DAO.addUser(u2);
		

//		DistributoreAutomatico d1 = new DistributoreAutomatico();
//		d1.setStato(Status.ATTIVO);
//
//		distributoreDAO.addTicketDispenser(d1);

//		biglietto biglietto1 = new biglietto();
//		biglietto1.generateTicket(new GregorianCalendar (2023, 02, 12), distributoreDAO.getDispenserByID(1));
		
//
//		bigliettoDAO.addTicket(biglietto1);
//		bigliettoDAO.validateTicket(bigliettoDAO2.getTicketByID(464675), new GregorianCalendar (2023, 02, 10), veicoloDAO.getVehicleByID(1));
		System.out.println(bigliettoDAO.getAllTicketsByDate(new GregorianCalendar (2023, 02, 9)));
		
//		tessera tessera2 = new tessera();
//		tessera2.generaTessera(new GregorianCalendar (2023, 02, 12), utenteDAO.getUtenteByID(2));
//		
//		abbonamenti a1 = new abbonamenti();
//		a1.generaAbbonamento(new GregorianCalendar (2023, 02, 12), vale_abbonamento.MENSILE);
//	
//		tessera2.setAbbonamento(a1);
//		utente u = utenteDAO.getUtenteByID(2);
//		u.setTessera(tessera2);
//		utenteDAO.updateUser(u);
//	
//		RivenditoreAutorizzato r1 = new RivenditoreAutorizzato();
//		r1.setNome("L'edicola di Gianni che batte i panni");
		
//		tesseraDAO.addTessera(tessera2);
//		
		
		
//		utente u1 = utenteDAO.getUtenteByID(1);
//		u1.setBiglietto(bigliettoDAO.getTicketByID(257303));
//		utenteDAO.updateUser(u1);
		
//		utente u2 = utenteDAO.getUtenteByID(2);
//
//		
//		abbonamentoDAO.checkSub(u2, LocalDate.of(2023,04,14));
		
		
		
		
		
		
//		
//		tratta tr1 = new tratta();
//		tr1.creaTratta("Roma Termini", "Milano Centrale", 12, 18);
//		tr1.setTempoMedioTratta(6);
//		tr1.setTratta_completata(false);
//		
//
//		trattaDAO tr1DAO = new trattaDAO();
//		tr1DAO.addRoute(tr1);
//		
//		
//		
//		veicolo v1 = new veicolo();
//		v1.creaVeicolo(tipoveicolo.TRAM, stato.SERVIZIO);
//		
//		veicoloDAO.addVehicle(v1);
		
		
		
		

		
	}

	
}
