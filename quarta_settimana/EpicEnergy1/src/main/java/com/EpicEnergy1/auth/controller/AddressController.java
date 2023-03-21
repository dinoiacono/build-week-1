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

import com.EpicEnergy1.Models.Address;
import com.EpicEnergy1.Services.AddressService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/adresses")
public class AddressController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<Address>> getAllAddress(){
		return new ResponseEntity<List<Address>>(addressService.getAllAddresses(),HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Address> getAddressId(@PathVariable Long id){
		return new ResponseEntity<Address>(addressService.getAddressId(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Address> createAddress(@RequestBody Address address){
		Address a = addressService.createAddress(address);
		return new ResponseEntity<Address>(addressService.createAddress(address),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable Address address){
		return new ResponseEntity<Address>(addressService.updateAddress(address),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeAddress(@PathVariable Long id){
		return new ResponseEntity<String>(addressService.removeAddress(id),HttpStatus.OK);
	}
	
}
