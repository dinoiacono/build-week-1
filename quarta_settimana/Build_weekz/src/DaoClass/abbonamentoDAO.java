package DaoClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import Biglietteria.abbonamenti;
import Biglietteria.utente;
import Util.util;

public class abbonamentoDAO {
	
	
	/*
	 * <h1>AGGIUNGI ABBONAMENTO AL DB!</h1>
	 * 
	 * @param abbonamenti Abbonamento da aggiungere 
	 */
	public void addSubscription(abbonamenti a) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Abbonamento aggiunto al DB");
}
	
	/*
	 * <h1>STAMPA VALIDITA' ABBONAMENTO!</h1>
	 * 
	 * @param utente Utente da controllare 
	 * @param Date Data da controllare 
	 */
	public void checkSub(utente u, LocalDate d) {
		Date d1 = u.getTessera().getAbbonamento().getData_scadenza();
//		if(d.isBefore(d1)) {
//			System.out.println("Abbonamento ancora valido");
//		} else {
//			System.out.println("Abbonamento Scaduto! Beccate sta multa!");
//		}
	}
	
	public static String format(GregorianCalendar calendar) {
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MMM-dd");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());

	    return dateFormatted;
	}
}
