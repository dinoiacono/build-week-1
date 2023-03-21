package com.EpicEnergy1.Models;

import java.math.BigDecimal;
import javax.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fattura")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class Fattura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer anno;
	
	private Date data;
	
	private BigDecimal importo;
	
	private Integer numero;
	
	@Enumerated(EnumType.STRING)
	@Column(name="stato_fattura")
	private FatturaEnum statoFattura;
	
}

