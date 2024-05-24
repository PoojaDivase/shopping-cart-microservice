package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleException(ItemNotFoundException e) {
		return new ResponseEntity<>("Item NOT found in cart: " + e.getMessage(),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
