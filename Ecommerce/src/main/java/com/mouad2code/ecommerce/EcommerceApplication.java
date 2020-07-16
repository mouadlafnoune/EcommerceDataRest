package com.mouad2code.ecommerce;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mouad2code.ecommerce.dao.RoleRepository;
import com.mouad2code.ecommerce.dao.UserRepository;
import com.mouad2code.ecommerce.entity.Role;
import com.mouad2code.ecommerce.entity.RoleEnum;
import com.mouad2code.ecommerce.entity.User;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(EcommerceApplication.class, args);
		
		
	
  RoleRepository roleRepository = ctx.getBean(RoleRepository.class); Role
  roleUser = new Role(RoleEnum.ROLE_USER); Role roleAdmin = new
  Role(RoleEnum.ROLE_ADMIN); roleRepository.save(roleUser);
  roleRepository.save(roleAdmin);
  
  UserRepository userRepository = ctx.getBean(UserRepository.class); User user=
  new User("mouad", "123456", true); user.setRoles(Arrays.asList(roleUser));
  
  userRepository.save(user);
  
  User admin = new User("lafnoune", "123456", true);
  admin.setRoles(Arrays.asList(roleUser, roleAdmin));
  userRepository.save(admin);
 
	}

}
