package com.mostafa.set.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	private String title;
	private String size;
	@JsonProperty("unit_price")
	private double unitPrice;
	private String description;

	public Product(String title, String size, double unitPrice, String description) {
		this.title = title;
		this.size = size;
		this.unitPrice = unitPrice;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
