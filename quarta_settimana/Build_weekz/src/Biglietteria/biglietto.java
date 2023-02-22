package Biglietteria;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="biglietto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class biglietto{

	@Id
	@Column(name="num_biglietto", unique=true)
	private int num_biglietto;

	@Column(name="data_rilascio")
	private Date data_rilascio;
	
	@OneToOne(mappedBy = "biglietto")
	private utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_distributore", nullable=true)
	private DistributoreAutomatico macchinetta;
	
	@ManyToOne
	@JoinColumn(name="id_rivenditore", nullable=true)
	private RivenditoreAutorizzato rivenditore;

	public biglietto() {
		super();
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
