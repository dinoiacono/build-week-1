package DaoClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import Biglietteria.abbonamenti;
import Biglietteria.biglietto;
import Biglietteria.utente;
import Util.util;

public class abbonamentoDAO {
	
	static SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
	public void checkSub(utente u, GregorianCalendar d) {
		Date d1 = u.getTessera().getAbbonamento().getData_scadenza();
		String data = formatoData.format(d.getTime());
		Date prova;
		try {
			prova = formatoData.parse(data);
				if(d1.compareTo(prova) < 0) {
					System.out.println("Abbonamento scaduto!");
			}else {
				System.out.println("Abbonamento valido!");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

}
