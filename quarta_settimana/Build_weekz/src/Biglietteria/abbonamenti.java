package Biglietteria;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="abbonamenti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class abbonamenti implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	@Column(name="nomeUtente")
	private String nome_utente;
	@Column(name="data_rilascio")
	private Date data_rilascio;
	@Column(name="NumTessera")
	private int numero_tessera;
	@Enumerated(EnumType.STRING)
	@Column(name="luogoEmissione")
	private luogoemissione luogoemissione;
	@Enumerated(EnumType.STRING)
	@Column(name="durata")
	private vale_abbonamento durata;
	public abbonamenti() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_utente() {
		return nome_utente;
	}
	public void setNome_utente(String nome_utente) {
		this.nome_utente = nome_utente;
	}
	public Date getData_rilascio() {
		return data_rilascio;
	}
	public void setData_rilascio(Date data_rilascio) {
		this.data_rilascio = data_rilascio;
	}
	public int getNumero_tessera() {
		return numero_tessera;
	}
	public void setNumero_tessera(int numero_tessera) {
		this.numero_tessera = numero_tessera;
	}
	public luogoemissione getLuogoemissione() {
		return luogoemissione;
	}
	public void setLuogoemissione(luogoemissione luogoemissione) {
		this.luogoemissione = luogoemissione;
	}
	public vale_abbonamento getDurata() {
		return durata;
	}
	public void setDurata(vale_abbonamento durata) {
		this.durata = durata;
	}
	
	
}
