package com.example.demomongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demomongo.model.Country;
import com.example.demomongo.repository.CountryRepository;

@Service
public class CountryAdapter 
{
	@Autowired
	private CountryRepository repository;
	
	public List<Country> findAll()
	{
		return repository.findAll();
	}
}
