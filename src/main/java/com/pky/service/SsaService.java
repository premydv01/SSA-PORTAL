package com.pky.service;

import java.util.List;

import com.pky.model.SsnEnrollmentRequest;

public interface SsaService {
	
	public List<String> getAllStatesNames();
	public Long ssnEnrollment(SsnEnrollmentRequest req);
	
	public String checkEnrollment(Long ssn,String stateName);
	

}
