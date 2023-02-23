package Biglietteria;


import java.time.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="tessera")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class tessera {
	
	@Id
	@Column(name="num_tessera", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_tessera;
	
	@Column(name="data_rilascio")
	private LocalDate data_rilascio;
	
	@Column(name="data_scadenza")
	private LocalDate data_scadenza ;
	
	@Enumerated(EnumType.STRING)
	@Column(name="validità")
	private String validitaTess;
	
	@OneToOne(mappedBy = "tessera")
	private utente utente;
	
	public tessera() {
		super();
	}

	public Date getData_rilascio() {
		return data_rilascio;
	}

	public void setData_rilascio(GregorianCalendar d) {
		this.data_rilascio = d.getTime();
	}

	public int getNum_tessera() {
		return num_tessera;
	}

	public Date getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(GregorianCalendar d) {
		d.add((GregorianCalendar.YEAR), 1);
		this.data_scadenza = d.getTime();
	}

	public utente getUtente() {
		return utente;
	}

	public void setUtente(utente utente) {
		this.utente = utente;
	}
	
    
    public void generaTessera(GregorianCalendar d, utente u) {
    	setData_rilascio(d);
    	setData_scadenza(d);
    	setUtente(u);
    }
	
	
	
}
