package com.mostafa.set.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JSONGeneratorService {
	/**
	 * Generates a JSON string representation of the provided object.
	 * 
	 * @param object the object to generate json for
	 * @return a String containing the JSON presentation of the object
	 * @throws JsonProcessingException
	 */
	String generateJSON(Object object) throws JsonProcessingException;
}
