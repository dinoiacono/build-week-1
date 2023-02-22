package Biglietteria;


import java.sql.Date;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
	private int num_biglietto;

=======
	@Column(name="Id")
	private Integer id;
	@Column(name="DataEmission")
	private Date data_emissione;
	@Enumerated(EnumType.STRING)
	@Column(name="luogoEmissione")
	private luogoemissione luogoemissione;
>>>>>>> e2642a66 (pushata)
	@Column(name="data_rilascio")
	private Date data_rilascio;
	
	@OneToOne(mappedBy = "biglietto")
	private utente utente;
	
	@ManyToOne
	@JoinColumn(name="id_distributore", nullable=false)
	private DistributoreAutomatico macchinetta;
	
	@ManyToOne
	@JoinColumn(name="id_rivenditore", nullable=false)
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

<<<<<<< HEAD
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



=======
	public Date getData_emissione() {
		return data_emissione;
	}

	public void setData_emissione(Date data_emissione) {
		this.data_emissione = data_emissione;
	}

	public luogoemissione getLuogoemissione() {
		return luogoemissione;
	}

	public void setLuogoemissione(luogoemissione luogoemissione) {
		this.luogoemissione = luogoemissione;
	}

>>>>>>> e2642a66 (pushata)
	public Date getData_rilascio() {
		return data_rilascio;
	}



	public void setData_rilascio(Date data_rilascio) {
		this.data_rilascio = data_rilascio;
	}

	
    public static int numGenerator() {
        Random rand = new Random(); 
        return rand.nextInt(999999-100000) + 100000;
    }
}
