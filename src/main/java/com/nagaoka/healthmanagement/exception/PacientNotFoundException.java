package com.nagaoka.healthmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacientNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public PacientNotFoundException(String cpf) {
		super("Pacient with CPF " + cpf + " does not exist in our database.");
	}
}