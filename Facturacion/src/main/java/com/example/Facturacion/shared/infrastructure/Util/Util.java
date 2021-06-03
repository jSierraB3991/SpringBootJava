package com.example.Facturacion.shared.infrastructure.Util;

import com.example.Facturacion.shared.infrastructure.exception.BusinessException;
import com.example.Facturacion.shared.infrastructure.exception.NotFoundException;

public class Util
{
	private Util() {
		
	}
	
	public static void throwException(String code, String param) 
	{
		throw new BusinessException(code + ": " + param);
	}
	
	public static void notFoundException(String code, String param) 
	{
		throw new NotFoundException(code, param);
	}
}
