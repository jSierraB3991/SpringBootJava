package com.example.Facturacion.domain.modeldomain;

import com.example.Facturacion.shared.domain.Id;
import com.example.Facturacion.shared.domain.NameProduct;
import com.example.Facturacion.shared.domain.ValueProduct;

public class Product 
{
	private final Id id;
	private final NameProduct nombre;
	private final ValueProduct valor;
	
	private Product(Id id, NameProduct nombre, ValueProduct valor) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}

	public static Product of(Id id, NameProduct nombre, ValueProduct valor) {
		return new Product(id, nombre, valor);
	}

	public Id getId() { 
		return id; 
	}
	public NameProduct getNombre() { 
		return nombre; 
	}
	public ValueProduct getValor() { 
		return valor; 
	}
}
