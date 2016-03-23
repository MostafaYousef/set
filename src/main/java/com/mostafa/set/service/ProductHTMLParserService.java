package com.mostafa.set.service;

import java.io.IOException;

import com.mostafa.set.model.Result;

public interface ProductHTMLParserService {
	/**
	 * Fetches the product data and returns a Result object with all the products.
	 * 
	 * @param url the url to the product page
	 * @return the Result object containing all the Products
	 * @throws IOException 
	 */
	Result getProductResult(String url) throws IOException;
}
