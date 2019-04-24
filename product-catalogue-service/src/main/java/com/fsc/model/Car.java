package com.fsc.model;

public class Car {

	private Long id;
	private Long stock;
	private String name;
	private String type;

	public Car() {
	}

	public Car(Long id, Long stock, String name, String type) {
		this.id = id;
		this.stock = stock;
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", stock=" + stock + ", name=" + name + ", type=" + type + "]";
	}

}
