package Biglietteria;

import Veicoli.*;
import javax.persistence.*;


@Entity
@Table(name="utente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id", unique=true)
	private int id;
	
	@Column(name="nome" , nullable = false)
	private String nome;
	
	@Column(name="cognome" , nullable = false)
	private String cognome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tessera", referencedColumnName = "num_tessera")
	private tessera tessera;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "biglietto", referencedColumnName = "num_biglietto")
	private biglietto biglietto;
	
	public utente() {
		super();
	}



	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public tessera getTessera() {
		return tessera;
	}



	public void setTessera(tessera tessera) {
		this.tessera = tessera;
	}


	public biglietto getBiglietto() {
		return biglietto;
	}



	public void setBiglietto(biglietto biglietto) {
		this.biglietto = biglietto;
	}



	@Override
	public String toString() {
		return "utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", tessera=" + tessera
				+ ", biglietto=" + biglietto + "]";
	}
	

	
}
