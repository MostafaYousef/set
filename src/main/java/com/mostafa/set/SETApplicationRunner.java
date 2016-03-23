package com.mostafa.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mostafa.set.model.Result;
import com.mostafa.set.service.JSONGeneratorService;
import com.mostafa.set.service.ProductHTMLParserService;

@Component
public class SETApplicationRunner implements CommandLineRunner {
	@Value("${product.url}")
	private String productUrl;

	@Autowired
	private ProductHTMLParserService productHTMLParserService;
	@Autowired
	private JSONGeneratorService jsonGeneratorService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Fetching product data...");
		Result result = productHTMLParserService.getProductResult(productUrl);

		System.out.println("Generating JSON...");
		String json = jsonGeneratorService.generateJSON(result);

		System.out.println("Done!");
		System.out.println(json);
	}
}
