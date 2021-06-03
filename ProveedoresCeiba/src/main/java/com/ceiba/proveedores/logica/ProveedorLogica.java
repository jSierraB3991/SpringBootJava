package com.ceiba.proveedores.logica;

import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.proveedores.Biblioteca.IVerficarDireccion;
import com.ceiba.proveedores.Biblioteca.IVerificarNombre;
import com.ceiba.proveedores.Biblioteca.IVerificarTelefono;
import com.ceiba.proveedores.Repositorio.ProveedoresRepository;
import com.ceiba.proveedores.modelo.Proveedor;
import com.ceiba.proveedores.modelo.Respuesta;

@Service
public class ProveedorLogica implements IProveedorLogica {

	@Autowired
	private ProveedoresRepository repositorio;
	@Autowired
	private IVerificarNombre iverficarnombre;
	@Autowired
	private IVerificarTelefono iverificarTelefono;
	@Autowired
	private IVerficarDireccion iverificarDireccion;
	
	@Override
	public List<Proveedor> obtenerTodosProveedores() {
		return repositorio.findAll();
	}

	@Override
	public Proveedor obtenerPorId(int id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) 
	{
		Respuesta<Object> respuesta = iverficarnombre.verificarNombre(proveedor.getNombre());
		if(!respuesta.getOk())
			throw new RuntimeException(respuesta.getMensaje());	
		
		respuesta = iverificarTelefono.verificarTelefono(proveedor.getTelefono());
		if(!respuesta.getOk())
			throw new RuntimeException(respuesta.getMensaje());
		
		respuesta = iverificarDireccion.verificarDireccion(proveedor.getDireccion());
		if(!respuesta.getOk())
			throw new RuntimeException(respuesta.getMensaje());
		
		if(EsDomingo(proveedor.getFechaRegistro().getDay())) 
			throw new RuntimeException("El dia de registro no puede ser domingo");	
		return this.repositorio.save(proveedor);
	}

	@Override
	public Proveedor modificarProveedor(Proveedor proveedor) 
	{
		Respuesta<Object> respuesta = iverficarnombre.verificarNombre(proveedor.getNombre());
		if(!respuesta.getOk())
			throw new RuntimeException(respuesta.getMensaje());
		respuesta = iverificarTelefono.verificarTelefono(proveedor.getTelefono());
		if(!respuesta.getOk())
			throw new RuntimeException(respuesta.getMensaje());
		proveedor.setFechaRegistro(repositorio.findById(proveedor.getId()).get().getFechaRegistro());
		return this.repositorio.save(proveedor);
	}
	
	private Boolean EsDomingo(int dia) 
	{
		return dia == 6;
	}
}
