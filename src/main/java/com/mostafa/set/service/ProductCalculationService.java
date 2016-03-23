package com.mostafa.set.service;

import java.util.List;

import com.mostafa.set.model.Product;

public interface ProductCalculationService {
	double getUnitPriceSum(List<Product> products);
}
