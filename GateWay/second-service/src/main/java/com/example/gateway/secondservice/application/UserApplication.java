package com.example.gateway.secondservice.application;

import java.util.List;

import com.example.gateway.secondservice.domain.model.User;
import com.example.gateway.secondservice.domain.service.UserService;
import com.example.gateway.secondservice.shared.domain.model.IdUser;

public class UserApplication 
{
	private UserService userService;
	
	public UserApplication(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> findAll()
	{
		return userService.finAll();
	}
	
	public User findById(IdUser id) 
	{
		return userService.findById(id);
	}
	
	public User save(User user) 
	{
		return userService.save(user);
	}
	
	public User update(User user) 
	{
		return userService.update(user);
	}
	
	public void delete(IdUser id) 
	{
		userService.delete(id);
	}
}
