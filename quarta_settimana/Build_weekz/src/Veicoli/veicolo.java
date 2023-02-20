package Veicoli;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

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
	@Column(name="data_servizio")
	private Date data_servizio;
	@Enumerated(EnumType.STRING)
	@Column(name="stato")
	private stato stato;
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
	public void setN_posti(int n_posti) {
		this.n_posti = n_posti;
	}
	public Date getData_servizio() {
		return data_servizio;
	}
	public void setData_servizio(Date data_servizio) {
		this.data_servizio = data_servizio;
	}
	public stato getStato() {
		return stato;
	}
	public void setStato(stato stato) {
		this.stato = stato;
	}
}
