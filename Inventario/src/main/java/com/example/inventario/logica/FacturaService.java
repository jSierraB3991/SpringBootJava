package com.example.inventario.logica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.model.Factura;
import com.example.inventario.model.Item;
import com.example.inventario.model.ItemPrduct;
import com.example.inventario.model.Product;
import com.example.inventario.repositori.IFacturaRepository;
import com.example.inventario.repositori.IItemRepository;
import com.example.inventario.repositori.productoRepository;

@Service
public class FacturaService implements IFacturaService
{
	@Autowired
	private IItemRepository repoItem;
	@Autowired
	private productoRepository repoProduct;
	@Autowired
	private IFacturaRepository repoFactura;

	@Override
	public List<ItemPrduct> GetListProductByFactura(int factura) 
	{
		List<Item> listItem = repoItem.findByFactura(factura);
		List<ItemPrduct> listItemProduct = new ArrayList<ItemPrduct>();
		
		for (Item item : listItem) {
			Product p = repoProduct.findById(item.getProduct()).get();
			listItemProduct.add(new ItemPrduct(item, p));
		}
		
		return listItemProduct;
	}

	@Override
	public Factura AddProductToFactura(Item item) 
	{
		Product p = repoProduct.findById(item.getProduct()).get();
		item.setValorItem(p.getValue() * item.cantidad());
		
		Factura factura = new Factura();
		if(item.getFactura()==0) {
			factura.setValorTotal(item.getValorItem());
			factura = repoFactura.save(factura);
		}
		else {
			factura = repoFactura.findById(item.getFactura()).get();
			factura.setValorTotal(item.getValorItem() + factura.getValorTotal());
		}
		item.setFactura(factura.getId());
		repoItem.save(item);
		
		return factura;
	}

	@Override
	public List<Factura> GetAllFactura() {
		return repoFactura.findAll();
	}

	@Override
	public void DeleteFactura(int id) 
	{
		List<Item> listItem = repoItem.findByFactura(id);
		for (Item item : listItem) {
			repoItem.deleteById(item.getId());
		}
		this.repoFactura.deleteById(id);
	}
	
}
