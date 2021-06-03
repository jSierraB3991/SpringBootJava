package com.example.Facturacion.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Facturacion.application.UserApplication;
import com.example.Facturacion.domain.service.UserService;
import com.example.Facturacion.infrastructure.rest.UserRest;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	private final UserApplication userApplication;
	
	@Autowired
	public UserController(UserService userService,
			BCryptPasswordEncoder passwordEncoder) {
		this.userApplication = new UserApplication(userService, passwordEncoder);
	}
	
	@PostMapping
	public UserRest save(@RequestBody UserRest userRest) {
		return userApplication.save(userRest);
	}
}
