package com.pky.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pky.model.SsnEnrollmentRequest;
import com.pky.service.SsaService;

@RestController
public class SsnEnrollmentRestController {
	@Autowired
	private SsaService service;
	
	@PostMapping(value = "/ssnEnrollment",
			 			consumes = {"application/json","application/xml"}
			
			)
	public ResponseEntity<String> enroll(@RequestBody SsnEnrollmentRequest req){
		ResponseEntity<String> response=null;
				Long ssn=service.ssnEnrollment(req);
		String body="Your SSN Enrollment Completed Successfully, Your SSN ::"+ssn;
		
		response=new ResponseEntity<String>(body,HttpStatus.CREATED);
		return response;
		
	}

}
