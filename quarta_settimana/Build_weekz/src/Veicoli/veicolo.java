package Veicoli;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import Biglietteria.biglietto;
import Biglietteria.utente;



@Entity
@Table(name="veicoli")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class veicolo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="n_posti")
	private int n_posti;
	
	@Enumerated(EnumType.STRING)
	@Column(name="stato")
	private stato stato;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoveicolo")
	private tipoveicolo tipoveicolo;
	
	@OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL)
	private Set<utente> utenti;
	
	@OneToMany(mappedBy = "veicolo", cascade = CascadeType.ALL)
	private Set<biglietto> biglietti;
	
	@ManyToOne
	@JoinColumn(name="tratta", nullable=true)
	private tratta tratta;
	
	public veicolo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getN_posti() {
		return n_posti;
	}
	public void setN_posti() {
		if(this.getTipoveicolo() == tipoveicolo.TRAM) {
			this.n_posti = 50;
		}else {
			this.n_posti = 30;
		}
	}	
	public stato getStato() {
		return stato;
	}
	public void setStato(stato stato) {
		this.stato = stato;
	}
	public Set<biglietto> getBiglietti() {
		return biglietti;
	}
	public void setBiglietti(Set<biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	public tipoveicolo getTipoveicolo() {
		return tipoveicolo;
	}
	public void setTipoveicolo(tipoveicolo tipoveicolo) {
		this.tipoveicolo = tipoveicolo;
	}
	public Set<utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(Set<utente> utenti) {
		this.utenti = utenti;
	}
	public tratta getTratta() {
		return tratta;
	}
	public void setTratta(tratta tratta) {
		this.tratta = tratta;
	}
	
}
