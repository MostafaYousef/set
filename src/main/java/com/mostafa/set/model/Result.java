package com.mostafa.set.model;

import java.util.List;

import com.mostafa.set.util.ProductUtil;

public class Result {
	private List<Product> results;
	
	public Result(List<Product> results) {
		this.results = results;
	}

	public List<Product> getResults() {
		return results;
	}

	public double getTotal() {
		return ProductUtil.getUnitPriceSum(results);
	}
}
