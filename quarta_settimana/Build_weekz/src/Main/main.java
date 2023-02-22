package Main;

import DaoClass.*;
import Util.util;
import Veicoli.veicolo;
import Biglietteria.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.persistence.*;




public class main {

	public static void main(String[] args) {
		
//		utente utente1 = new utente();
//		utente1.setNome("Dino");
//		utente1.setCognome("Plutonuo");
//		
//		DistributoreAutomatico macchinetta1 = new DistributoreAutomatico();
//		macchinetta1.setStato(Status.ATTIVO);
//		
//		DistributoreAutomaticoDAO macchinetta1DAO = new DistributoreAutomaticoDAO();
//		//macchinetta1DAO.saveMacchinetta(macchinetta1);
//		
//		biglietto ticket1 = new biglietto();
//
//		ticket1.setNum_biglietto();
//		ticket1.setData_rilascio(new GregorianCalendar (2023, 02, 12));		
//		ticket1.setMacchinetta(macchinetta(1));
//				
//		//utenteDAO utente1DAO = new utenteDAO();
//		//utente1DAO.CreaUtenteDB(utente1);
//		
//		//bigliettoDAO ticket1DAO = new bigliettoDAO();
//		//ticket1DAO.saveBiglietto(ticket1);
//		
//		RivenditoreAutorizzato rivenditore1 = new RivenditoreAutorizzato();
//		rivenditore1.setNome("L'edicola di Gianni che batte i panni");
//		
//		RivenditoreAutorizzatoDAO rivenditore1DAO = new RivenditoreAutorizzatoDAO(); 
//		rivenditore1DAO.saveRivenditore(rivenditore1);
		
	}	
	public static DistributoreAutomatico macchinetta(int id) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT x FROM DistributoreAutomatico x WHERE id = " + id);
		return (DistributoreAutomatico) q.getSingleResult();
	}
	
	
	public static int conteggioTotaleBiglietti(Date data) {
		int contatore = 0;
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT * FROM veicoli");
		List<veicolo> mezzi = q.getResultList();
		for(veicolo v : mezzi) {
			for(biglietto b : v.getBiglietti()) {
				if(b.getData_vidimazione().compareTo(data)<0) {
					contatore++;
				}
			}
		}
		return contatore;
	}
}
