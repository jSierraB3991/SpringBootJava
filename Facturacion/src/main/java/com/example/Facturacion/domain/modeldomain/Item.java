package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.CountItem;
import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.ValueItem;

public class Item 
{
	private final CountItem cantidad;
	private final Codigo codigo;
	private final Product producto;
	private final ValueItem valor;
	
	private Item(Codigo codigo, CountItem cantidad, Product producto, ValueItem valor) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.producto = producto;
		this.valor = valor;
	}
	
	public CountItem getCantidad() {
		return cantidad;
	}
	public Product getProducto() {
		return producto;
	}
	public ValueItem getValor() {
		return valor;
	}
	public Codigo getCodigo() {
		return codigo;
	}
	
	public static Item of(Codigo codigo, CountItem cantidad, Product producto, ValueItem valor) 
	{
		return new Item(codigo, cantidad, producto, valor);
	}
}
