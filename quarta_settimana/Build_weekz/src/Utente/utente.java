package Utente;

import javax.persistence.*;

@Entity
@Table(name="utente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(name="registrazione")
	private registrato registrato;
	public utente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public registrato getRegistrato() {
		return registrato;
	}
	public void setRegistrato(registrato registrato) {
		this.registrato = registrato;
	}
}
