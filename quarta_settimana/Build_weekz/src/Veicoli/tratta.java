package Veicoli;

import javax.persistence.*;

@Entity
@Table(name="tratta")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="punto_partenza")
	private String punto_partenza;
	@Column(name="punto_destinazione")
	private String punto_destinazione;
	@Column(name="tempoMedioTratta")
	private int tempoMedioTratta;
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
	public int getTempo_tratta() {
		return tempoMedioTratta;
	}
	public void setTempo_tratta(int tempo_tratta) {
		this.tempoMedioTratta = tempo_tratta;
	}
	
}
