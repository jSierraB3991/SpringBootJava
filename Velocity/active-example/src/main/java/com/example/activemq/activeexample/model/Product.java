package com.example.activemq.activeexample.model;

import java.io.Serializable;

public class Product implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int quanty;
	
	public Product() { }
	
	public Product(int id, String name, int quanty) {
		this.id = id;
		this.name = name;
		this.quanty = quanty;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getQuanty() { return quanty; }
	public void setQuanty(int quanty) { this.quanty = quanty; }
	
	@Override
	public String toString() {
		return "Product [id: " + id + ", name: "+ name + ", quanty: " + quanty +"]";
	}
}