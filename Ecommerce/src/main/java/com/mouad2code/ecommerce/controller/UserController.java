package com.mouad2code.ecommerce.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	
	@RequestMapping("/api/user")
	public Principal user(Principal user) {
		return user;
	}

}
