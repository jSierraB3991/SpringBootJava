package com.example.Facturacion.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Facturacion.domain.modeldomain.UserDomain;
import com.example.Facturacion.domain.service.UserService;
import com.example.Facturacion.infrastructure.mapper.v2.UserMapper;
import com.example.Facturacion.infrastructure.rest.UserRest;

public class UserApplication 
{
	private final BCryptPasswordEncoder passwordEncoder;
	private final UserService service;
	
	public UserApplication(UserService service, 
			BCryptPasswordEncoder passwordEncoder) {
		this.service = service;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserRest save(UserRest user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserDomain userDomain = UserMapper.INSTANCE.getByRest(user);
		user = UserMapper.INSTANCE.getRest(this.service.save(userDomain));
		user.setPassword("");
		return user;
	}
}
