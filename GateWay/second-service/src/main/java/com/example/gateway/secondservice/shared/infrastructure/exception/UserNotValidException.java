package com.example.gateway.secondservice.shared.infrastructure.exception;

public class UserNotValidException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public UserNotValidException(String info) {
		super("USER NOT VALID" + info);
	}
}
