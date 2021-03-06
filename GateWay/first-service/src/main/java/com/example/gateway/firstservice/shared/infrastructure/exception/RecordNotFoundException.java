package com.example.gateway.firstservice.shared.infrastructure.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message, String info) {
		super(message+ ", info: " + info);
	}
}
