package com.mostafa.set.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.apache.log4j.Logger;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.mostafa.set.model.Result;
import com.mostafa.set.model.Product;

@Service
public class ProductHTMLParserServiceImpl implements ProductHTMLParserService {
	private static final Logger LOG = Logger.getLogger(ProductHTMLParserServiceImpl.class);

	@Override
	public Result getProductResult(String url) throws IOException {
		Document document;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			LOG.error("Could not get product page!", e);
			throw e;
		}

		Elements products = document.select("div.product");
		if(products.size() < 1) {
			LOG.error("No product found on product page!");
			return null;
		}
		
		final List<Product> productList = new ArrayList<>(products.size());
		//parallel process the products for multi-thread processing 
		products.parallelStream().unordered().forEach(p -> {
			final Product product = new Product(p.select("a").text(), null, 
					Double.parseDouble(p.select("p.pricePerUnit").text().replaceAll("[^0-9\\.]", "")), null);
			
			String productUrl = p.select("a").attr("href");
			try {
				updatePDPData(productUrl, product);
			} catch (IOException | NumberFormatException e) {
				LOG.error("Failed to update PDP data for product: " + product.getTitle(), e);
			}
			
			productList.add(product);
		});

		return new Result(productList);
	}
	
	private void updatePDPData(String url, final Product product) throws IOException {
		Response pdpResponse = Jsoup.connect(url).execute();
		String contentLength = pdpResponse.header("content-length");
		Document pdpDocument = pdpResponse.parse();
		// Get the first div.productText (sibling) after h3.productDataItemHeader with the value 'Description'
		product.setDescription(pdpDocument.select("h3.productDataItemHeader:contains(Description) ~ div.productText").first().text());
		product.setSize(Integer.parseInt(contentLength) / 1000 + "kb");
	}
}
