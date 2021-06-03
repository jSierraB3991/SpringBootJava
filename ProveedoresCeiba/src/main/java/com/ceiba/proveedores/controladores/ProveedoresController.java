package com.ceiba.proveedores.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.proveedores.logica.IProveedorLogica;
import com.ceiba.proveedores.modelo.Proveedor;
import com.ceiba.proveedores.modelo.Respuesta;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

	@Autowired
	private IProveedorLogica logica;
	
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Proveedor> ListaProveedores() {
		return logica.obtenerTodosProveedores();
	}
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Proveedor Proveedor(@PathVariable int id) {
		return logica.obtenerPorId(id);
	}
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Respuesta<Proveedor> AgregarProveedor(@Valid @RequestBody Proveedor proveedor )
    {
    	try {
    		Proveedor agregado = this.logica.agregarProveedor(proveedor);
    		return new Respuesta<Proveedor>(true, agregado, "Proveedor Agregado Correctamente!!");
    	}
    	catch(Exception ex){
    		return new Respuesta<Proveedor>(false, ex.getMessage());
    	}
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Respuesta<Proveedor> ActualizarProveedor(@Valid @RequestBody Proveedor proveedor )
    {
    	try {
    		Proveedor agregado = this.logica.modificarProveedor(proveedor);
    		return new Respuesta<Proveedor>(true, agregado, "Proveedor Actulizado Correctamente!!");
    	}
    	catch(Exception ex){
    		return new Respuesta<Proveedor>(false, ex.getMessage());
    	}
    }
    
}
