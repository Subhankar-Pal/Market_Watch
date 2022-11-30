package com.stocksearch.stocksearch.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BadCredeltialsExceptions extends BadCredentialsException{

	public BadCredeltialsExceptions(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
		
	}


}
