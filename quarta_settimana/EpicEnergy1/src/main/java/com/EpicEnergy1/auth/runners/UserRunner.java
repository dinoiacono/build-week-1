package com.EpicEnergy1.auth.runners;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.EpicEnergy1.Models.Address;
import com.EpicEnergy1.Models.Fattura;
import com.EpicEnergy1.Repositories.AddressRepo;
import com.EpicEnergy1.Repositories.FatturaRepo;
import com.EpicEnergy1.auth.*;
import com.EpicEnergy1.auth.roles.ERole;
import com.EpicEnergy1.auth.roles.Role;
import com.EpicEnergy1.auth.roles.RoleRepository;
import com.EpicEnergy1.auth.users.User;
import com.EpicEnergy1.auth.users.UserRepository;

@Component
public class UserRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder encoder;
	@Autowired FatturaRepo fatturaRepo;
	@Autowired AddressRepo addressRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
		Set<Role> adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		Set<Role> moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		Set<Role> userRole = new HashSet<Role>();
		userRole.add(user);
		
		User userAdmin = new User();
		userAdmin.setNome("Admino");
		userAdmin.setCognome("Stretor");
		userAdmin.setUsername("admin");
		userAdmin.setEmail("admin@example.com");
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setRoles(adminRole);
		userRepository.save(userAdmin);
		
		User simpleUser = new User();
		simpleUser.setNome("Mario");
		simpleUser.setCognome("Rossi");
		simpleUser.setUsername("mariorossi");
		simpleUser.setEmail("m.rossi@example.com");
		simpleUser.setPassword(encoder.encode("12345"));
		simpleUser.setRoles(userRole);
		userRepository.save(simpleUser);
		
		User userModerator = new User();
		userModerator.setNome("Giuseppe");
		userModerator.setCognome("Verdi");
		userModerator.setUsername("giuver");
		userModerator.setEmail("g.verdi@example.com");
		userModerator.setPassword(encoder.encode("qwerty"));
		userModerator.setRoles(moderatorRole);
		userRepository.save(userModerator);
		
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
