package com.mostafa.set.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.mostafa.set.model.Product;

public class ProductUtilTest {
	@Test
	public void verifyUnitPriceSum() {
		assertEquals(16.8, ProductUtil.getUnitPriceSum(Arrays.asList(
				new Product("T1", null, 3.1, null),
				new Product("T2", null, 2.4, null),
				new Product("T3", null, 11.0, null),
				new Product("T4", null, 0.3, null))), 0);
	}

	@Test
	public void verifyUnitPriceSumForNoProducts() {
		assertEquals(0, ProductUtil.getUnitPriceSum(new ArrayList<>()), 0);
	}

	@Test
	public void verifyUnitPriceSumForNullProducts() {
		assertEquals(-1, ProductUtil.getUnitPriceSum(null), 0);
	}
}
