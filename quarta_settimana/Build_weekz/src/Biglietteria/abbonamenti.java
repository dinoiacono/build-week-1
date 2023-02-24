package Biglietteria;



import java.util.*;
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
	
	@Column(name="data_scadenza")
	private Date data_scadenza;
	
	@Enumerated(EnumType.STRING)
	@Column(name="validita")
	private vale_abbonamento durata;
	
	@OneToOne(mappedBy = "abbonamento")
	private tessera tessera;
	
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


	public RivenditoreAutorizzato getRivenditore() {
		return rivenditore;
	}


	public void setRivenditore(RivenditoreAutorizzato rivenditore) {
		this.rivenditore = rivenditore;
	}


	public Date getData_rilascio() {
		return data_rilascio;
	}


	public void setData_rilascio(GregorianCalendar data_rilascio) {
		this.data_rilascio = data_rilascio.getTime();
	}

	public Date getData_scadenza() {
		return data_scadenza;
	}


	public void setData_scadenza(GregorianCalendar d, vale_abbonamento t) {
		switch (t) {
		case MENSILE:
			d.add((GregorianCalendar.MONTH), 1);
			this.data_scadenza = d.getTime();
			break;
		case SETTIMANALE:
			d.add((GregorianCalendar.DAY_OF_MONTH), 7);
			this.data_scadenza = d.getTime();
			break;
		default:
			d.add((GregorianCalendar.DAY_OF_MONTH), 1);
			this.data_scadenza = d.getTime();
			break;
		}	
	}


	public vale_abbonamento getDurata() {
		return durata;
	}


	public void setDurata(vale_abbonamento durata) {
		this.durata = durata;
	}


	public DistributoreAutomatico getMacchinetta() {
		return macchinetta;
	}


	public void setMacchinetta(DistributoreAutomatico macchinetta) {
		this.macchinetta = macchinetta;
	}


	public tessera getTessera() {
		return tessera;
	}


	public void setTessera(tessera tessera) {
		this.tessera = tessera;
	}
	
	public void generaAbbonamento(GregorianCalendar d, vale_abbonamento t ) {
		setData_rilascio(d);
		setData_scadenza(d,t);
		setDurata(t);
	}
	
	
	
	
}
