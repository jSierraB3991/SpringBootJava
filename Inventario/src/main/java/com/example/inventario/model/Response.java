package com.example.inventario.model;

public class Response<T> {

	T obj;
	public Boolean getIsSuccess() { return this.isSuccess; }
	public String getMessage() { return this.message; }
	public T getResult() { return this.result; }
	
	public void setResult(T result) { this.result = result;}
	public void setMessage(String message) { this.message = message;}
	public void setIsSuccess(Boolean isSuccess) { this.isSuccess = isSuccess;}
	
	public Response() {}
	public Response(Boolean isSuccess, String message, T result) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.result = result;
	}
	
	private Boolean isSuccess;
	private String message;
	private T result;
}
