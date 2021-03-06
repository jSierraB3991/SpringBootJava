package com.example.inventario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public Double getValue() { return this.value; }
	
	public void setId(int id) { this.id = id;}
	public void setValue(Double value) { this.value = value; }
	public void setName(String name) { this.name = name; }
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private Double value;
}
