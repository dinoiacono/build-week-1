package DaoClass;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import Biglietteria.biglietto;
import Util.util;
import Veicoli.tratta;
import Veicoli.veicolo;

public class veicoloDAO {

	static 	EntityManager em = util.getEntityManagerFactory().createEntityManager();

	public void addVehicle(veicolo v) {
		
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
		
		System.out.println("Veicolo creato nel DB");
	}
	
	public List<biglietto> getAllTicketByVehicle(veicolo v){
		Query q = em.createQuery("SELECT * FROM biglietti WHERE id_veicolo = " + v.getId() );
		return q.getResultList();
	}
	
	public int getTicketNumberValidatedByDate(veicolo v, Date date) {
		List<biglietto> lista = getAllTicketByVehicle(v);
		for(biglietto b : v.getBiglietti()) {
			if(b.getData_vidimazione().compareTo(date)<0)lista.add(b);
		}
		return lista.size();
	}
	

	
	public void updateVehicleTickets(veicolo v) {
		List<biglietto> lista = getAllTicketByVehicle(v);
		for(biglietto b : lista) {
			if(b.getData_vidimazione().compareTo(date)<0)lista.add(b);
		}
	 
	}
	
	
}
