package com.example.exampletwilio.model;

public class Mail 
{
	private String mensaje;
	private String phneNumber;
	
	public Mail() { }
	
	public String getMensaje() 
	{
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getPhneNumber() {
		return phneNumber;
	}
	public void setPhneNumber(String phneNumber) {
		this.phneNumber = phneNumber;
	}
}
