package com.example.Facturacion.shared.domain;

public class UserName 
{
	private final String value;
	
	public UserName(String user) {
		this.value = user;
	}
	
	public String getValue() {
		return this.value;
	}
}
