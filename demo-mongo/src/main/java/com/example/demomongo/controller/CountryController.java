package com.example.demomongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demomongo.model.Country;
import com.example.demomongo.service.CountryAdapter;

@RestController
@RequestMapping("/api/country")
public class CountryController
{
	@Autowired
	private CountryAdapter service;
	
	@GetMapping
	public List<Country> findAll(){
		return service.findAll();
	}
}
