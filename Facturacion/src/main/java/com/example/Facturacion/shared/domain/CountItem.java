package com.example.Facturacion.shared.domain;

import com.example.Facturacion.shared.infrastructure.Util.Util;

public class CountItem 
{
	private final int value;
	
	public CountItem(int cantidad)
	{
		this.value = cantidad;
		if(cantidad<1)
			Util.throwException("exception.cantidadItemError", Integer.toString(cantidad));
	}

	public int getValue() { return value; }
}
