package com.nagaoka.healthmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DoctorNotFoundException(String crm) {
		super("Doctor with CRM " + crm + " does not exist in our database.");
	}

}
