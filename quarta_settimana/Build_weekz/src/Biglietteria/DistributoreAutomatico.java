package Biglietteria;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="distributoriAutomatici")
public class DistributoreAutomatico  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", unique=true)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="status")
	private Status stato;
	
	@OneToMany(mappedBy = "macchinetta")
	private Set<biglietto> biglietti;
	
	@OneToMany(mappedBy = "macchinetta", cascade = CascadeType.ALL)
	private Set<abbonamenti> abbonamenti;

	
	public DistributoreAutomatico() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Status getStato() {
		return stato;
	}


	public void setStato(Status stato) {
		this.stato = stato;
	}


	public Set<biglietto> getBiglietti() {
		return biglietti;
	}


	public void setBiglietti(Set<biglietto> biglietti) {
		this.biglietti = biglietti;
	}


	public Set<abbonamenti> getAbbonamenti() {
		return abbonamenti;
	}


	public void setAbbonamenti(Set<abbonamenti> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	
	
   
}
