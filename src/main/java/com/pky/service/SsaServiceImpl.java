package com.pky.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pky.entity.SsnMasterEntity;
import com.pky.model.SsnEnrollmentRequest;
import com.pky.repository.SsnMasterRepository;
import com.pky.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl  implements SsaService{
	@Autowired
	private StatesMasterRepository  statesRepo;
	@Autowired
	private SsnMasterRepository ssnRepo;

	@Override
	public List<String> getAllStatesNames() {
		return	statesRepo.findStateNames();
		
	}

	@Override
	public Long ssnEnrollment(SsnEnrollmentRequest req) {
		SsnMasterEntity entity=new SsnMasterEntity();
		BeanUtils.copyProperties(req, entity);
		    SsnMasterEntity savedEntity=ssnRepo.save(entity);
		    if(savedEntity!=null) {
		    	return savedEntity.getSsn();
		    }
		return null;
	}

	@Override
	public String checkEnrollment(Long ssn, String stateName) {
	      SsnMasterEntity entity=ssnRepo.findBySsnAndStateName(ssn, stateName);
	      
	      if(entity!=null) {
	    	  return "VALID";
	      }
		return "IN-VALID";
	}
	

}
