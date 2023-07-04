package com.infosys.gcp.service;

import java.util.Map;

import com.infosys.gcp.repo.DTO.ApplicationRequest;

public interface service {
    
    Integer getRemaingSlotsCount();
    
    Map<String,String> apply(ApplicationRequest request);
    
}
