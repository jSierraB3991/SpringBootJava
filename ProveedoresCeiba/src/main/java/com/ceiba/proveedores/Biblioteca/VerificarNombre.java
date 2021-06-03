package com.ceiba.proveedores.Biblioteca;

import org.springframework.stereotype.Component;

import com.ceiba.proveedores.modelo.Respuesta;

@Component
public class VerificarNombre implements IVerificarNombre {

	@Override
	public Respuesta<Object> verificarNombre(String nombre) {
		if(nombre.length()<5) {
			return new Respuesta<Object>(false, "El nombre debe tener minimo 5 caracteres");
		}
		
		String palindromo = new String();
		char [] invertir = nombre.toLowerCase().trim().toCharArray();
		for(int i = invertir.length-1 ; i>=0; i--){
			palindromo += invertir[i];
		}
		
		if(nombre.trim().toLowerCase().equals(palindromo)) {
			return new Respuesta<Object>(false, "El nombre no debe ser palindromo");
		}
		return new Respuesta<Object>(true, "");
	}
}
