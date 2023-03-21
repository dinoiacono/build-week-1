package com.EpicEnergy1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EpicEnergy1.Models.Address;
import com.EpicEnergy1.Repositories.AddressRepo;

@Service
public class AddressService {

	@Autowired AddressRepo addressRepo;

	public Address createDevice(Address address) {
		addressRepo.save(address);
		return address;
	}
	
	public Address getDeviceid(Long id) {
		return addressRepo.findById(id).get();
	}
	
	public List<Address> getAllDevices(){
		return (List<Address>) addressRepo.findAll();
	}
	
	public Address updateDevice(Address address) {
		addressRepo.save(address);
		return address;
	}
	
	public String removeDevice(Long id) {
		addressRepo.deleteById(id);
		return "Address deleted";
	}
	
}