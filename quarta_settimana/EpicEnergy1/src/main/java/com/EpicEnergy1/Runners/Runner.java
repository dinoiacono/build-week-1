package com.EpicEnergy1.Runners;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.Component;

import com.EpicEnergy1.Models.Address;
import com.EpicEnergy1.Models.Fattura;
import com.EpicEnergy1.Models.User;
import com.EpicEnergy1.Repositories.*;

@Component
public class Runner implements ApplicationRunner {

	@Autowired UserRepo userRepo;
	@Autowired FatturaRepo fatturaRepo;
	@Autowired AddressRepo addressRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Run...");
		
		User utente1 = new User();
		utente1.setPartitaIva(123456789L);
		utente1.setEmail("Erchicco@example.com");
		utente1.setDataInserimento( new GregorianCalendar(2022,06,22).getTime());
		utente1.setDataUltimoContatto(new GregorianCalendar(2023,12,12).getTime());
		utente1.setFatturatoAnnuale(100000);
		utente1.setPec("ErChicco@Piglialoarcul.pec.com");
		utente1.setTelefono(1234567890L);
		utente1.setEmailContatto("Miolavoro@madonnina.com");
		utente1.setNomeContatto("Mario");
		utente1.setCognomeContatto("Rossi");
		utente1.setTelefonoContatto(1234467890L);
		userRepo.save(utente1);
		
		Address address1 = new Address();
		address1.setVia("le mani dal culo");
		address1.setCivico(666);
		address1.setLocalita("Bologna");
		address1.setCap(20444L);
		address1.setComune("Bologna");
		addressRepo.save(address1);
		
		Fattura fattura1 = new Fattura();
		fattura1.setAnno(2023);
		fattura1.setData(new GregorianCalendar(2022,07,30).getTime());
		fattura1.setImporto(new BigDecimal(10000.0));
		fatturaRepo.save(fattura1);
	}

}
