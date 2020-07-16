package com.mouad2code.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouad2code.ecommerce.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String str);
}
