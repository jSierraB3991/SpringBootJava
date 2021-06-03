package com.example.Facturacion.shared.domain;

public class UserPassword 
{
	private final String value;
	
	public UserPassword(String user) {
		this.value = user;
	}
	
	public String getValue() {
		return this.value;
	}
}

