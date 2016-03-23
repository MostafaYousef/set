package com.mostafa.set.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class JSONGeneratorServiceImpl implements JSONGeneratorService {
	private ObjectMapper mapper;

	@PostConstruct
	public void init() {
		mapper = new ObjectMapper();
		// Enable JSON pretty print
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	/**
	 * Generates a JSON string representation of the provided object.
	 * 
	 * @param object the object to generate json for
	 * @return a String containing the JSON presentation of the object
	 * @throws JsonProcessingException
	 */
	@Override
	public String generateJSON(Object object) throws JsonProcessingException {
		return mapper.writer().writeValueAsString(object);
	}
}
