package com.mostafa.set.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.mostafa.set.model.Product;

public class ProductCalculationServiceImplTest {
	private ProductCalculationServiceImpl service = new ProductCalculationServiceImpl();
	
	@Test
	public void verifyUnitPriceSum() {
		assertEquals(16.8, service.getUnitPriceSum(Arrays.asList(
				new Product("T1", null, 3.1, null),
				new Product("T2", null, 2.4, null),
				new Product("T3", null, 11.0, null),
				new Product("T4", null, 0.3, null))), 0);
	}

	@Test
	public void verifyUnitPriceSumForNoProducts() {
		assertEquals(0, service.getUnitPriceSum(new ArrayList<>()), 0);
	}

	@Test
	public void verifyUnitPriceSumForNullProducts() {
		assertEquals(-1, service.getUnitPriceSum(null), 0);
	}
}
