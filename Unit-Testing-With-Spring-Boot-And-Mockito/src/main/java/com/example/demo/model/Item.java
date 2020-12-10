package com.example.demo.model;

public class Item {

	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;

	public Item(Integer id, String name, Double price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getQuantity()=" + getQuantity() + "]";
	}
}
