package com.ceiba.proveedores;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.proveedores.logica.IProveedorLogica;
import com.ceiba.proveedores.modelo.Proveedor;

@SpringBootTest
class ProveedoresApplicationTests 
{
	@Autowired
	private IProveedorLogica logica;
	
	@Before
	public void Inicial() 
	{
		System.out.println("Que nervios ...");
	}
	
	@Test
	public void VerficarLista() {
		List<Proveedor>proveedores = logica.obtenerTodosProveedores();
		for (Proveedor proveedor : proveedores) {
			System.out.println(proveedor.toString());
		}
	}
	
	@Test
	public void VerificarObtenerUno() 
	{
		System.out.println(logica.obtenerPorId(1).toString());
	}
	
	@Test
	public void VerificarGuardar() 
	{
		try {
			
			Proveedor p = new Proveedor("Juan Perez", new Date("2019-07-15") , 5678901, "Calle Luna");
			logica.agregarProveedor(p);
			System.out.println("Guardado Correcto");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	@Test
	public void VerificarActulizar() 
	{
		try {
			
			Proveedor p = logica.obtenerPorId(1);
			p.setNombre("Juan Pablo Montoya");
			logica.modificarProveedor(p);
			System.out.println("Guardado Correcto");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
