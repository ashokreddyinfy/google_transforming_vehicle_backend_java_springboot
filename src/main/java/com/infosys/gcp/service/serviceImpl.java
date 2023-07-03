package com.infosys.gcp.service;

import org.springframework.stereotype.Service;

@Service
public class serviceImpl  implements service {

	@Override
	public Integer getRemaingSlotsCount() {
        // TO-DO call cache to get value
        return 100;
	}    
}
