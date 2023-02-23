package Veicoli;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="tratta")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tratta")
	private int id_tratta;

	@Column(name="punto_partenza")
	private String punto_partenza;
	
	@Column(name="punto_destinazione")
	private String punto_destinazione;
	
	@Column(name="tratta_completata")
	
	private Boolean tratta_completata;
	
	@Column(name="tempoMedioTratta")
	private int tempoMedioTratta;
	
	@Column(name="orarioPartenza")
	private int orarioPartenza;
	
	@Column(name="orarioArrivo")
	private int orarioArrivo;
	
	@OneToMany(mappedBy = "tratta", cascade = CascadeType.ALL)
	private Set<veicolo> mezzi;
	
	public tratta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getPunto_partenza() {
		return punto_partenza;
	}




	public void setPunto_partenza(String punto_partenza) {
		this.punto_partenza = punto_partenza;
	}




	public String getPunto_destinazione() {
		return punto_destinazione;
	}




	public void setPunto_destinazione(String punto_destinazione) {
		this.punto_destinazione = punto_destinazione;
	}




	public boolean getTratta_completata() {
		return tratta_completata;
	}




	public void setTratta_completata(boolean tratta_completata) {
		this.tratta_completata = tratta_completata;
	}




	public int getTempoMedioTratta() {
		return tempoMedioTratta;
	}




	public void setTempoMedioTratta(int tempoMedioTratta) {
		this.tempoMedioTratta = tempoMedioTratta;
	}




	public int getOrarioPartenza() {
		return orarioPartenza;
	}




	public void setOrarioPartenza(int orarioPartenza) {
		this.orarioPartenza = orarioPartenza;
	}




	public int getOrarioArrivo() {
		return orarioArrivo;
	}




	public void setOrarioArrivo(int orarioArrivo) {
		this.orarioArrivo = orarioArrivo;
	}




	public Set<veicolo> getMezzi() {
		return mezzi;
	}




	public void setMezzi(Set<veicolo> mezzi) {
		this.mezzi = mezzi;
	}




	public int getId_tratta() {
		return id_tratta;
	}
	
	
	// CUSTOM
	
	public int get_tempo_effettivo() {
		return orarioArrivo - orarioPartenza;
	}

	public void creaTratta(String p, String d, int op, int oa ) {
		setPunto_partenza(p);
		setPunto_destinazione(d);
		setOrarioPartenza(op);
		setOrarioArrivo(oa);
	}
	
}
