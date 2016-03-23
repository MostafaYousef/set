package com.mostafa.set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mostafa.set.model.Result;
import com.mostafa.set.service.JSONGeneratorService;
import com.mostafa.set.service.ProductHTMLParserService;

@Component
public class SETApplicationRunner implements CommandLineRunner {
	private static final Logger LOG = Logger.getLogger(SETApplicationRunner.class);

	@Value("${product.url}")
	private String productUrl;

	@Autowired
	private ProductHTMLParserService productHTMLParserService;
	@Autowired
	private JSONGeneratorService jsonGeneratorService;
	
	@Override
	public void run(String... args) {
		try {
			System.out.println("Fetching product data...");
			Result result = productHTMLParserService.getProductResult(productUrl);

			try {
				System.out.println("Generating JSON...");
				String json = jsonGeneratorService.generateJSON(result);

				System.out.println("Done!");
				System.out.println("------------------------------------------------");
				System.out.println(json);
				System.out.println("------------------------------------------------");
			} catch (JsonProcessingException e) {
				LOG.error("An error occurred during json generation of the product data!", e);
			}
		} catch (Exception e) {
			LOG.error("An error occurred during fetch of product data!", e);
		}
	}
}
