package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class NameProduct 
{	
	private final String value;
	
	public NameProduct(String name) 
	{
		this.value = name;
		try 
		{
			if (name.length() < 0 || !name.matches("[A-Z].*")) 
				Util.throwException("exception.invalidNameProduct", name);
		} catch (Exception e) {
			Util.throwException("exception.invalidNameProduct", name);
		}
	}

	public String getValue() {
		return value;
	}
}