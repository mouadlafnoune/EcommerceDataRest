package com.mouad2code.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mouad2code.ecommerce.dao.UserRepository;
import com.mouad2code.ecommerce.entity.User;



@Service
@Primary
public class UserService implements ICrudService<User, Long> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
	}

	@Override
	public void saveAll(Iterable<User> iterable) {
		userRepository.saveAll(iterable);
		
	}

}
