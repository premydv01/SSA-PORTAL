package com.pky.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pky.service.SsaService;



@RestController
public class SsnValidationRestController {
	@Autowired
	private SsaService service;
	
	
	@GetMapping(value ="/validateSsn/{ssn}/{state}")
	public ResponseEntity<String> validate(@PathVariable("ssn") String ssn,@PathVariable("state") String stateName){
		ResponseEntity<String> response=null;

				String status=service.checkEnrollment(Long.parseLong(ssn), stateName);
				response=new ResponseEntity<String>(status,HttpStatus.OK);
		
		return response;
	}

}
