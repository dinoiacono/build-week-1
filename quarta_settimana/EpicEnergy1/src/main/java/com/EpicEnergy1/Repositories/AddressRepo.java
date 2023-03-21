package com.EpicEnergy1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EpicEnergy1.Models.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
