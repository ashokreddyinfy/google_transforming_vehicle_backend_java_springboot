package com.infosys.gcp.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.infosys.gcp.repo.DTO.ApplicationRequest;

@Service
public class serviceImpl implements service {
	Logger logger = LoggerFactory.getLogger(serviceImpl.class);

	@Override
	public Integer getRemaingSlotsCount() {
		// TO-DO call cache to get value
		return 100;
	}

	@Override
	public Map<String, String> apply(ApplicationRequest request) {
		logger.info(request.toString());
		return null;
		
	}
}
