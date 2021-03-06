package com.example.gateway.firstservice.shared.domain.model;

public class NameProduct {

	private final String value;
	
	public NameProduct(String name) {
		this.value = name;
	}
	
	public String getValue() 
	{
		return this.value;
	}
}
