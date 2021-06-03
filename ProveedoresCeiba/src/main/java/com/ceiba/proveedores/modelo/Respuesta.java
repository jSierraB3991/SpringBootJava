package com.ceiba.proveedores.modelo;

public class Respuesta<T> {
	T obj;
	
	private Boolean ok;
	private String mensajeError;
	private T resultado;
	
	public Respuesta() {}
	
	public Respuesta(Boolean ok, String msg) 
	{
		this.ok = ok;
		this.mensajeError = msg;
	}
	
	public Respuesta(Boolean ok, T resultado, String msg) 
	{
		this.ok = ok;
		this.resultado = resultado;
		this.mensajeError = msg;
	}
	
	public Boolean getOk() {
		return this.ok;
	} 
	public void setOk(Boolean ok){
		this.ok = ok;
	}

	public String getMensaje() {
		return this.mensajeError;
	} 
	public void setMensaje(String mensaje){
		this.mensajeError = mensaje;
	}

	public T getRessultado() {
		return this.resultado;
	} 
	public void setResultado(T resultado) {
		this.resultado = resultado;
	}
}
