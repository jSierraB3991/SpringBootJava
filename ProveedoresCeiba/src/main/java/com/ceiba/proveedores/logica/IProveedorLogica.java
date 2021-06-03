package com.ceiba.proveedores.logica;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ceiba.proveedores.modelo.Proveedor;

@Service
public interface IProveedorLogica 
{
	List<Proveedor> obtenerTodosProveedores();
	Proveedor obtenerPorId(int id);
	Proveedor agregarProveedor(Proveedor proveedor);
	Proveedor modificarProveedor(Proveedor proveedor);
}
