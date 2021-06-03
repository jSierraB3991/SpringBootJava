package com.ceiba.proveedores.Biblioteca;

import org.springframework.stereotype.Component;
import com.ceiba.proveedores.modelo.Respuesta;

@Component
public class VerficarDireccion implements IVerficarDireccion {

	@Override
	public Respuesta<Object> verificarDireccion(String direccion) {
		
		if(!direccion.toLowerCase().startsWith("cl")) 
			return new Respuesta<Object>(false, "La direccion debe iniciar con CL");
		String regexExp = "[^aeiou]";
		int cantidad = direccion.replaceAll(regexExp, "").trim().toLowerCase().length();
		if(cantidad > 3) 
			return new Respuesta<Object>(false, "Solo se permiten direccion con 3 vocales");
		return new Respuesta<Object>(true, "");
	}

}
