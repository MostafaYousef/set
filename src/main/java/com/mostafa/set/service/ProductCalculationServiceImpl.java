package com.mostafa.set.service;

import java.util.List;

import com.mostafa.set.model.Product;

public class ProductCalculationServiceImpl implements ProductCalculationService {
	/**
	 * Calculated the sum of all the unit prices for the provided products.
	 * 
	 * @param products the list of products
	 * @return the sum of the unit prices for all the products
	 */
	@Override
	public double getUnitPriceSum(List<Product> products) {
		if (products == null) {
			return -1;
		}
		// Calculate and round the total sum
		return Math.round(products.stream().mapToDouble(p -> p.getUnitPrice()).sum() * 100) / 100.0d;
	}
}
