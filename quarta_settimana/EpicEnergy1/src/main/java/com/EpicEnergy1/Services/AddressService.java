package com.EpicEnergy1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EpicEnergy1.Models.Address;
import com.EpicEnergy1.Repositories.AddressRepo;

@Service
public class AddressService {

	@Autowired AddressRepo addressRepo;

	public Address createAddress(Address address) {
		addressRepo.save(address);
		return address;
	}
	
	public Address getAddressId(Long id) {
		return addressRepo.findById(id).get();
	}
	
	public List<Address> getAllAddresses(){
		return (List<Address>) addressRepo.findAll();
	}
	
	public Address updateAddress(Address address) {
		addressRepo.save(address);
		return address;
	}
	
	public String removeAddress(Long id) {
		addressRepo.deleteById(id);
		return "Address deleted";
	}
	
}