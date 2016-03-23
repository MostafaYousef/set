package com.mostafa.set.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JSONGeneratorService {
	String generateJSON(Object object) throws JsonProcessingException;
}
