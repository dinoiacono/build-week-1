package Biglietteria;


import java.util.*;
import Veicoli.*;
import javax.persistence.*;

@Entity
@Table(name="biglietto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class biglietto{

	@Id
	@Column(name="num_biglietto", unique=true)
	private int num_biglietto;

	@Column(name="data_rilascio")
	private Date data_rilascio;
	
	@Column(name="data_vidimazione")
	private Date data_vidimazione;
	
	@Enumerated(EnumType.STRING)
	@Column(name="statoBiglietto")
	private statusbiglietto statusbiglietto;
	
	@OneToOne(mappedBy = "biglietto")
	private utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_veicolo", nullable=true)
	private veicolo veicolo;
	
	@ManyToOne
	@JoinColumn(name="id_distributore", nullable=true)
	private DistributoreAutomatico macchinetta;
	
	@ManyToOne
	@JoinColumn(name="id_rivenditore", nullable=true)
	private RivenditoreAutorizzato rivenditore;

	public biglietto() {
		super();
	}

	public Date getData_vidimazione() {
		return data_vidimazione;
	}
	
	public void setData_vidimazione(Date data_vidimazione) {
		this.data_vidimazione = data_vidimazione;
	}


	public statusbiglietto getStatusbiglietto() {
		return statusbiglietto;
	}



	public void setStatusbiglietto(statusbiglietto statusbiglietto) {
		this.statusbiglietto = statusbiglietto;
	}



	public int getNum_biglietto() {
		return num_biglietto;
	}



	public void setNum_biglietto() {
		this.num_biglietto = numGenerator();
	}

	public utente getUtente() {
		return utente;
	}



	public void setUtente(utente utente) {
		this.utente = utente;
	}



	public DistributoreAutomatico getMacchinetta() {
		return macchinetta;
	}



	public void setMacchinetta(DistributoreAutomatico macchinetta) {
		this.macchinetta = macchinetta;
	}



	public Date getData_rilascio() {
		return data_rilascio;
	}



	public void setData_rilascio(GregorianCalendar data_rilascio) {
		this.data_rilascio = data_rilascio.getTime();
	}
	
    public static int numGenerator() {
        Random rand = new Random(); 
        return rand.nextInt(999999-100000) + 100000;
    }
}
