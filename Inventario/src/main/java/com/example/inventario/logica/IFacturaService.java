package com.example.inventario.logica;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inventario.model.Factura;
import com.example.inventario.model.Item;
import com.example.inventario.model.ItemPrduct;

@Service
public interface IFacturaService 
{
	List<ItemPrduct> GetListProductByFactura(int factura);
	
	Factura AddProductToFactura(Item item);
	
	List<Factura> GetAllFactura();
	
	void DeleteFactura(int id);
}
