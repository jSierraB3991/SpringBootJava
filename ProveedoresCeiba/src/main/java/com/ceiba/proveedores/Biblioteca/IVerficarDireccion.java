package com.ceiba.proveedores.Biblioteca;

import com.ceiba.proveedores.modelo.Respuesta;

public interface IVerficarDireccion {
	public Respuesta<Object> verificarDireccion(String direccion);
}
