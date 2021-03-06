package com.example.gateway.secondservice.domain.service;

import java.util.List;

import com.example.gateway.secondservice.domain.model.User;
import com.example.gateway.secondservice.shared.domain.model.IdUser;

public interface UserService 
{
	public List<User> finAll();
	
	public User findById(IdUser id);
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(IdUser id);
}
