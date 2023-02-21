package Biglietteria;


import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name="tessera")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class tessera {
	
	@Id
	@Column(name="num_tessera", unique = true)
	private int num_tessera;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id; 
	
	@Column(name="data_rilascio")
	private LocalDateTime data_rilascio;
	
	@Column(name="data_scadenza")
	private LocalDateTime data_scadenza ;
	
	@OneToOne(mappedBy = "tessera")
	private utente utente;

	public tessera() {
		super();
	}

	public LocalDateTime getData_rilascio() {
		return data_rilascio;
	}

	public void setData_rilascio(LocalDateTime data_rilascio) {
		this.data_rilascio = data_rilascio;
	}

	public int getNum_tessera() {
		return num_tessera;
	}

	public void setNum_tessera() {
		this.num_tessera = numGenerator();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public LocalDateTime getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza() {
		this.data_scadenza = this.data_rilascio.plusYears(1);
	}

	public utente getUtente() {
		return utente;
	}

	public void setUtente(utente utente) {
		this.utente = utente;
	}
	
    public static int numGenerator() {
        Random rand = new Random(); 
        return rand.nextInt(999999-100000) + 100000;
    }
	
	
	
}
