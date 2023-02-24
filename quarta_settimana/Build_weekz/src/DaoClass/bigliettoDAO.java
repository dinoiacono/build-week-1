package DaoClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.persistence.*;


import Biglietteria.*;
import Util.util;
import Veicoli.veicolo;

public class bigliettoDAO {

	static EntityManager em = util.getEntityManagerFactory().createEntityManager();
	static SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void addTicket(biglietto b) {
		
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Biglietto aggiunto al DB");
	}
	
	public void updateTicket(biglietto b) {
		
		try {
			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		System.out.println("Biglietto aggiornato al DB");
	
	}
	
	public void validateTicket(biglietto bigl, GregorianCalendar data_vidimazione, veicolo v) {
		if(bigl.getStatusbiglietto() == statusbiglietto.NON_TIMBRATO) {
			bigl.setData_vidimazione(data_vidimazione.getTime());
			bigl.setStatusbiglietto();
			bigl.setVeicolo(v);
			updateTicket(bigl);
 		}else {
 			System.out.println("Biglietto già timbrato!!!");
 		}
		
	}
	
	public int getAllTicketsByDate(GregorianCalendar data) {
		int contatore=0;
		String d = formatoData.format(data.getTime());
		Query q = em.createQuery("SELECT b FROM biglietto b");
//		System.out.println(data); 
		List<biglietto> biglietti = q.getResultList();
		Date prova;
		try {
			prova = formatoData.parse(d);
			for (biglietto b : biglietti) {
				if(b.getData_vidimazione().compareTo(prova) < 0) {
					contatore ++;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return contatore;
	}
	
    public biglietto getTicketByID(int id) {
    	biglietto b = em.find(biglietto.class, id);
        if (b == null) {
            throw new EntityNotFoundException("Can't find Artist for ID " + id);
        }
        return b;
    }
}
