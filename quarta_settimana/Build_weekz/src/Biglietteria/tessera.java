package Biglietteria;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tessera")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class tessera implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id; 
	@Column(name="data_rilascio")
	private Date data_rilascio;

	public tessera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getData_rilascio() {
		return data_rilascio;
	}

	public void setData_rilascio(Date data_rilascio) {
		this.data_rilascio = data_rilascio;
	}
	
}
