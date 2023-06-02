package com.pky.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name ="SsnEnrollmentRequest" )
public class SsnEnrollmentRequest {

	private String fName;
	private String lName;
	private Date dob;	
	private String gender;	
	private String stateName;	

	

}
