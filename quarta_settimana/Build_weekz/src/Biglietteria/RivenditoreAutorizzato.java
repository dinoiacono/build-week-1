package Biglietteria;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="rivenditoreAutorizzato")
public class RivenditoreAutorizzato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true)
	private int id;
	
	@Column(name ="nome_rivenditore")
	private String nome;
	
	@OneToMany(mappedBy = "rivenditore",  cascade = CascadeType.ALL)
	private Set<biglietto> biglietti;
	
	@OneToMany(mappedBy = "rivenditore", cascade = CascadeType.ALL)
	private Set<abbonamenti> abbonamenti;

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

	public RivenditoreAutorizzato() {
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
	
	
   
}
