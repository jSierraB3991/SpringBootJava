package com.ceiba.proveedores.Biblioteca;

import org.springframework.stereotype.Component;
import com.ceiba.proveedores.modelo.Respuesta;

@Component
public class VerificarTelefono implements IVerificarTelefono {

	@Override
	public Respuesta<Object> verificarTelefono(int telefono) {
		
		if(String.valueOf(telefono).length()!=7) 
		{
			return new Respuesta<Object>(false, "El numero telefonico debe ser exactamente 7 digitos");	
		}
		return new Respuesta<Object>(true, "");
	}

}
