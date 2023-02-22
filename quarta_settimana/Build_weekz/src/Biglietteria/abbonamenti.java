package Biglietteria;


import java.sql.Date;
import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name="abbonamenti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class abbonamenti {

	@Id
	@Column(name="num_abbonamento", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero_abbonamento;
	
	@Column(name="data_rilascio")
	private Date data_rilascio;
	
	@Enumerated(EnumType.STRING)
	@Column(name="validita")
	private vale_abbonamento durata;
	
	@OneToOne(mappedBy = "abbonamento")
	private utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_distributore")
	private DistributoreAutomatico macchinetta;
	
	@ManyToOne
	@JoinColumn(name="id_rivenditore")
	private RivenditoreAutorizzato rivenditore;
	
	
	public abbonamenti() {
		super();
	}


	public int getNumero_abbonamento() {
		return numero_abbonamento;
	}


	public void setNumero_abbonamento(int numero_abbonamento) {
		this.numero_abbonamento = numero_abbonamento;
	}

	public Date getData_rilascio() {
		return data_rilascio;
	}


	public void setData_rilascio(Date data_rilascio) {
		this.data_rilascio = data_rilascio;
	}

	public vale_abbonamento getDurata() {
		return durata;
	}


	public void setDurata(vale_abbonamento durata) {
		this.durata = durata;
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
	
    public static int numGenerator() {
        Random rand = new Random(); 
        return rand.nextInt(999999-100000) + 100000;
    }
	
	
}
