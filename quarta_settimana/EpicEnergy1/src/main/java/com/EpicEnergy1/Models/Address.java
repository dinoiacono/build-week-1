package com.EpicEnergy1.Models;

import java.util.Date;
import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="indirizzo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String via;
	
	private int civico;
	
	private String localita;
	
	private Long cap;
	
	private String comune;
}
