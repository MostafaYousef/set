package com.mostafa.set.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mostafa.set.SETApplication;
import com.mostafa.set.model.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SETApplication.class)
@WebIntegrationTest({"server.port = 9000"})
public class ProductHTMLParserServiceImplTest {
	@Autowired
	private ProductHTMLParserServiceImpl service;

	@Test
	public void verifyGetProductResult() throws IOException {
		Result result = service.getProductResult("http://localhost:9000/test/product_root_page.html");
		assertEquals(7.1, result.getTotal(), 0);
		assertEquals(3, result.getResults().size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verifyGetProductResultInvalidUrl() throws IOException {
		service.getProductResult("http://www.google.com");
	}
}
