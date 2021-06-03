package com.example.Facturacion.application;

import java.util.UUID;

public class GetID 
{
	private GetID() {
	}
	
	public static String getId() 
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
