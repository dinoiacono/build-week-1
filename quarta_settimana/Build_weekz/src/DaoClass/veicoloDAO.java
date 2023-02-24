package DaoClass;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import Biglietteria.DistributoreAutomatico;
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
	
	
	public veicolo getVehicleByID(int id) {
    	veicolo v = em.find(veicolo.class, id);
        if (v == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        return v;
	}
	
}
