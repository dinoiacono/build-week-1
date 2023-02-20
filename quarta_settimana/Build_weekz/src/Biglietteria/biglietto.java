package Biglietteria;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="biglietto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class biglietto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	@Column(name="data_rilascio")
	private Date data_rilascio;

	public biglietto() {
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
	
}
