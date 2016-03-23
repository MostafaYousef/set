package com.mostafa.set.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mostafa.set.service.ProductCalculationService;

public class Result {
	@Autowired
	private ProductCalculationService productCalculationService;

	private List<Product> results;
	
	public Result(List<Product> results) {
		this.results = results;
	}

	public List<Product> getResults() {
		return results;
	}

	public double getTotal() {
		return productCalculationService.getUnitPriceSum(results);
	}
}
