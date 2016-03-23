package com.mostafa.set.service;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mostafa.set.SETApplication;
import com.mostafa.set.model.Product;
import com.mostafa.set.model.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SETApplication.class)
public class JSONGeneratorServiceImplTest {
	@Autowired
	private JSONGeneratorServiceImpl service;
	
	private static final String EXPECTED_JSON_RESULT = "{\"results\":[{\"title\":\"Product 1\",\"size\":\"30.0kb\",\"unit_price\":3.1,\"description\":\"This is the first product\"},{\"title\":\"Product 2\",\"size\":\"55.0kb\",\"unit_price\":2.4,\"description\":\"This is the second product\"}],\"total\":5.5}";
	private static final Result INPUT_OBJECT = new Result(
			Arrays.asList(
					new Product("Product 1", "30.0kb", 3.1, "This is the first product"),
					new Product("Product 2", "55.0kb", 2.4, "This is the second product")));

	@Test
	public void verifyGenerateJSON() throws JsonProcessingException, JSONException {
		JSONAssert.assertEquals(EXPECTED_JSON_RESULT, service.generateJSON(INPUT_OBJECT), JSONCompareMode.NON_EXTENSIBLE);
	}
}
