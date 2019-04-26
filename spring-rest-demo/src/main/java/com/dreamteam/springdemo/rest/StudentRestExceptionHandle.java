package com.dreamteam.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandle {

	// add exception handling code

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessege(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return RespomseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add exception handler ... to catch any other exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessege(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return RespomseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}