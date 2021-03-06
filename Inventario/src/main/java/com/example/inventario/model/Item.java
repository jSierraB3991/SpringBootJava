package com.example.inventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item 
{
	public int getId() { return this.id; }
	public int cantidad() { return this.cantidad; }
	public Double getValorItem() { return this.valorItem; }
	
	public void sertId(int id) { this.id = id;}
	public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	public void setValorItem(Double valorItem) { this.valorItem = valorItem;}

	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}

	public int getFactura() {
		return this.factura;
	}
	public void setFactura(int factura) {
		this.factura = factura;
	}

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@Column
	private int cantidad;
	
	@Column
	private Double valorItem;
	
	@Column
	private int product;

	@Column
	private int factura;
}
