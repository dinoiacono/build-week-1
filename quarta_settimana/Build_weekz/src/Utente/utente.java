package Utente;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="utente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class utente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
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
	public registrato getRegistrato() {
		return registrato;
	}
	public void setRegistrato(registrato registrato) {
		this.registrato = registrato;
	}
	
}
