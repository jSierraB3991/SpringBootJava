package com.example.Facturacion.infrastructure.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> 
{
	private Boolean isSuccess;
	
	private T data;
	
	public Response(Boolean isSuccess, T data) {
		this.isSuccess = isSuccess;
		this.data = data;
	}
}
