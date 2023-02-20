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
	@Column(name="data_rilascio")
	private Date data_rilascio;
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
	public Date getData_rilascio() {
		return data_rilascio;
	}
	public void setData_rilascio(Date data_rilascio) {
		this.data_rilascio = data_rilascio;
	}
	public vale_abbonamento getDurata() {
		return durata;
	}
	public void setDurata(vale_abbonamento durata) {
		this.durata = durata;
	}
	
}
