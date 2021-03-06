package com.example.inventario.model;


public class ItemPrduct 
{
	private Item item;
	private Product product;
	
	public ItemPrduct() {}
	public ItemPrduct(Item item, Product product) 
	{
		this.item = item;
		this.product = product;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
