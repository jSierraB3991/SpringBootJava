package com.example.Facturacion.domain.modeldomain;

import java.util.List;

import com.example.Facturacion.shared.domain.Codigo;
import com.example.Facturacion.shared.domain.NameBill;
import com.example.Facturacion.shared.domain.ValueBill;

public class Bill 
{
	private final Codigo codigo;
	private final NameBill nombre;
	private final ValueBill valor;
	private final List<Item> items;
	
	private Bill(Codigo codigo, NameBill nombre, ValueBill valor, List<Item> items) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.items = items;
	}
	
	public Codigo getCodigo() {
		return codigo;
	}
	public NameBill getNombre() {
		return nombre;
	}
	public ValueBill getValor() {
		return valor;
	}
	public List<Item> getItems() {
		return items;
	}
	
	public static Bill of(Codigo codigo, NameBill nombre, ValueBill valor, List<Item> items) {
		return new Bill(codigo, nombre, valor, items);
	}
}
