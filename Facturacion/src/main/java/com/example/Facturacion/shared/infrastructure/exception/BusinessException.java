package com.example.Facturacion.shared.infrastructure.exception;

public class BusinessException extends RuntimeException 
{
	
	private static final long serialVersionUID = -6270183634410328700L;

	public BusinessException(String code) {
		super(code);
	}
}
