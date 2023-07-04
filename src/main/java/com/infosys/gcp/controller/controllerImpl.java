package com.infosys.gcp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.gcp.repo.DTO.ApplicationRequest;
import com.infosys.gcp.service.service;

@RestController
public class controllerImpl {

    @Autowired
    private service svr;

    @GetMapping(value = "/getRemaingSlots")
    public ResponseEntity<Integer> getRemaingSlots() {

        try {
            Integer count = svr.getRemaingSlotsCount();
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/apply")
    public ResponseEntity<Map<String, String>> apply(@RequestBody ApplicationRequest request) {
        return new ResponseEntity<Map<String, String>>(svr.apply(request), HttpStatus.OK);
    }
}
