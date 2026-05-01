package com.example.demo.concurrent;

public class Product {
	
	private int id;
	private String name;
	private Stock stock;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Product(int id, String name, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	

}
