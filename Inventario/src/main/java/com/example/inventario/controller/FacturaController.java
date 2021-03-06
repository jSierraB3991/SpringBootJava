package com.example.inventario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventario.logica.IFacturaService;
import com.example.inventario.model.Factura;
import com.example.inventario.model.Item;
import com.example.inventario.model.ItemPrduct;
import com.example.inventario.model.Response;

@RestController
@RequestMapping("/api/Factura")
public class FacturaController 
{
	@Autowired
	private IFacturaService service;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Response<Factura> AddItem(@Valid @RequestBody Item item)
	{
		try {
			return new Response<Factura>(true, "", service.AddProductToFactura(item));
		}catch(Exception ex) {
			return new Response<Factura>(false, ex.getMessage(), null);
		}
	}
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public List<Factura> GetAllFacture()
	{
		return service.GetAllFactura();
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public Response<List<ItemPrduct>> GetAllProductByFactura(@PathVariable String id)
	{
		try {
			return new Response<List<ItemPrduct>>(true, "", service.GetListProductByFactura(Integer.parseInt(id)));
		} catch (Exception e) {
			return new Response<List<ItemPrduct>>(false, e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Response<String> DeleteByFactura(@PathVariable String id)
	{
		try {
			service.DeleteFactura(Integer.parseInt(id));
			return new Response<String>(true, "", "Factura Eliminda Correctamente");
		} catch (Exception e) {
			return new Response<String>(false, e.getMessage(), "");
		}
	} 
}
