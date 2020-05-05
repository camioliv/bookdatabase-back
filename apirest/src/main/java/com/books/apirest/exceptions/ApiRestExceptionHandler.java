package com.books.apirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiRestExceptionHandler {
	
	@ExceptionHandler(value = {ApiRestException.class})
	public ResponseEntity<Object> handleException(ApiRestException e){
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}

}
