package com.example.inventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Factura 
{
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public String getNameClient() { return this.nameClient; }
	public void setNameClient(String nameClient) { this.nameClient = nameClient; }
	
	public Double getValorTotal() { return this.valorTotal; }
	public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	@Column
	private String nameClient;

	@Column
	private Double valorTotal;
}
