package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class Codigo 
{
	private final String value;
	
	public Codigo(String codigo) 
	{
		this.value = codigo;
		try {
			if (codigo.length() < 5 || codigo.length() > 33) 
				Util.throwException("exception.codeError", codigo);
		} catch (Exception e) { 
			Util.throwException("exception.codeError", codigo);
		}
	}

	public String getValue() { 
		return value; 
	}
}
