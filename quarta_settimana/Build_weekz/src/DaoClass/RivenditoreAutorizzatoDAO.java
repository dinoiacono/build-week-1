package DaoClass;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import Biglietteria.RivenditoreAutorizzato;
import Biglietteria.abbonamenti;
import Biglietteria.biglietto;
import Util.util;

public class RivenditoreAutorizzatoDAO {

	public void saveRivenditore(RivenditoreAutorizzato r) {
		
		EntityManager em = util.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
            em.getTransaction().rollback(); 

		}
		finally {
			em.close();
		}
		
		System.out.println("Rivenditore aggiunto al DB");
}


public int contaBiglietti(Date periodo, RivenditoreAutorizzato r) {
	
	Set<biglietto> lista = r.getBiglietti();
	int contatore = 0;
	for(biglietto b : lista)
		if(b.getData_rilascio().compareTo(periodo) < 0) contatore++;
	return contatore;
}

public int contaAbbonamenti(Date periodo, RivenditoreAutorizzato r) {
	
	Set<abbonamenti> lista = r.getAbbonamenti();
	int contatore = 0;
	for(abbonamenti a : lista)
		if(a.getData_rilascio().compareTo(periodo) < 0) contatore++;
	return contatore;
}
}
