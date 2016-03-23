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

	@Override
	public String generateJSON(Object object) throws JsonProcessingException {
		return mapper.writer().writeValueAsString(object);
	}
}
