package com.example.gateway.secondservice.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gateway.secondservice.application.UserApplication;
import com.example.gateway.secondservice.domain.service.UserService;
import com.example.gateway.secondservice.infrastructure.mapper.UserMapper;
import com.example.gateway.secondservice.infrastructure.rest.UserRest;
import com.example.gateway.secondservice.shared.domain.model.IdUser;

@RestController
@RequestMapping("/user")
public class UsuarioController 
{
	private UserApplication userApp;
	
	public UsuarioController(@Autowired UserService userService) {
		userApp = new UserApplication(userService);
	}
	
	@GetMapping
	public List<UserRest> findAll()
	{
		return UserMapper.INSTANCE.GetRest(userApp.findAll());
	}
	
	@GetMapping("/{id}")
	public UserRest findById(@PathVariable String id) 
	{
		return UserMapper.INSTANCE.GetRest(userApp.findById(new IdUser(id)));
	}
	
	@PostMapping
	public UserRest save(@RequestBody UserRest user) 
	{
		return UserMapper.INSTANCE.GetRest(
				userApp.save(UserMapper.INSTANCE.GetDomainByRest(user)));
	}
	
	@PutMapping
	public UserRest update(@RequestBody UserRest user) 
	{
		return UserMapper.INSTANCE.GetRest(
				userApp.update(UserMapper.INSTANCE.GetDomainByRest(user)));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) 
	{
		userApp.delete(new IdUser(id));
	}
}
