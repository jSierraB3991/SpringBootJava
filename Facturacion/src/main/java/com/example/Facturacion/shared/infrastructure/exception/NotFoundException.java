package com.example.Facturacion.shared.infrastructure.exception;

public class NotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = -5739670567415270408L;
	
	public NotFoundException(String message, String params) {
		super(message + ":" + params);
	}
}
