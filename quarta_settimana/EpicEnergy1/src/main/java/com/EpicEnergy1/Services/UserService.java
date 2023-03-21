package com.EpicEnergy1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EpicEnergy1.Models.User;
import com.EpicEnergy1.Repositories.UserRepo;


@Service
public class UserService{
	
	@Autowired UserRepo userRepo;

	public User createUser(User user) {
		userRepo.save(user);
		return user;
	}
	
	public User getUserId(Long id) {
		return userRepo.findById(id).get();
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	public User updateUser(User user) {
		userRepo.save(user);
		return user;
	}
	
	public String removeUser(Long id) {
		userRepo.deleteById(id);
		return "User deleted";
	}
}

