package com.example.gateway.secondservice.shared.infrastructure.exception;

public class DuplicatedNameAndLastName extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public DuplicatedNameAndLastName(String info) {
		super("THE USER " + info + " NOT AVAILABLE");
	}
}
