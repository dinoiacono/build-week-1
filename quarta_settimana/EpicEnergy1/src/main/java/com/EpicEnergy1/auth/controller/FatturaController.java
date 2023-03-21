package com.EpicEnergy1.auth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EpicEnergy1.Models.Fattura;
import com.EpicEnergy1.Services.FatturaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fatture")
public class FatturaController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired FatturaService fatturaService;
	
	@GetMapping
	public ResponseEntity<List<Fattura>> getAllFatture(){
		return new ResponseEntity<List<Fattura>>(fatturaService.getAllFatture(),HttpStatus.OK);
	}
	
	@GetMapping("/Id")
	public ResponseEntity<Fattura> getFatturaId(@PathVariable Long id) {
		return new ResponseEntity<Fattura>(fatturaService.getFatturaId(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Fattura> createFattura(@RequestBody Fattura fattura) {
		Fattura f = fatturaService.createFattura(fattura);
		return new ResponseEntity<Fattura>(fatturaService.createFattura(fattura),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fattura> updateFattura(@PathVariable Fattura fattura) {
		return new ResponseEntity<Fattura>(fatturaService.updateFattura(fattura),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeFattura(@PathVariable Long id){
		return new ResponseEntity<String>(fatturaService.removeFattura(id),HttpStatus.OK);
	}
}
