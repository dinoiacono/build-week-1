package com.EpicEnergy1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EpicEnergy1.Models.Fattura;
import com.EpicEnergy1.Repositories.FatturaRepo;

@Service
public class FatturaService {

	@Autowired FatturaRepo fatturaRepo;
	
	public Fattura createDevice(Fattura fattura) {
		fatturaRepo.save(fattura);
		return fattura;
	}
	
	public Fattura getDeviceid(Long id) {
		return fatturaRepo.findById(id).get();
	}
	
	public List<Fattura> getAllDevices(){
		return (List<Fattura>) fatturaRepo.findAll();
	}
	
	public Fattura updateDevice(Fattura fattura) {
		fatturaRepo.save(fattura);
		return fattura;
	}
	
	public String removeDevice(Long id) {
		fatturaRepo.deleteById(id);
		return "Fattura deleted";
	}
	
}
