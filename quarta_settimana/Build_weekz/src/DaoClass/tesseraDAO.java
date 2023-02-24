package DaoClass;

import java.time.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Biglietteria.biglietto;
import Biglietteria.tessera;
import Biglietteria.utente;
import Util.util;
import Veicoli.veicolo;

public class tesseraDAO {

	public void addTessera(tessera tess) {
	EntityManager em = util.getEntityManagerFactory().createEntityManager();
	try {
		em.getTransaction().begin();
		em.persist(tess);
		em.getTransaction().commit();
	}
	catch (Exception ex) {
		em.getTransaction().rollback();
	}
	finally {
		em.close();
	}
	System.out.println("Tessera creata nel DB");
}
	
	public void checkCardByDate(utente u, Date validita) {
		if(u.getTessera().getData_scadenza().compareTo(validita) < 0) System.out.println("La tessera è ancora valida");
		else System.out.println("Tessera scaduta, rinnovala!");
	}
}
