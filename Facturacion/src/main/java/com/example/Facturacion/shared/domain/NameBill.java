package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class NameBill
{
	private final String value;
	
	public NameBill(String name) 
	{
		this.value = name;
		try 
		{
			if (name.length() < 0 || !name.matches("[A-Z].*")) 
				Util.throwException("exception.invalidNameBill", name);
		} catch (Exception e) {
			Util.throwException("exception.invalidNameBill", name);
		}
	}

	public String getValue() {
		return value;
	}
}