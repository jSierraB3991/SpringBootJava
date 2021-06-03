package com.ceiba.proveedores.Biblioteca;

import com.ceiba.proveedores.modelo.Respuesta;

public interface IVerificarTelefono {
	Respuesta<Object> verificarTelefono(int telefono);
}
