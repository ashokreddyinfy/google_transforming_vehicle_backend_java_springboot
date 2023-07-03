package com.infosys.gcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
