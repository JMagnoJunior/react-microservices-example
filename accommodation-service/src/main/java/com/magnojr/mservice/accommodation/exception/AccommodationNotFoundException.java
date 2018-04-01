package com.magnojr.mservice.accommodation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccommodationNotFoundException extends RuntimeException{
	public AccommodationNotFoundException(String message){
		super(message);
	}
}
