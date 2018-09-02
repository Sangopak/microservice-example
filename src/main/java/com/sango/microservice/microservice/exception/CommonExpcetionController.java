package com.sango.microservice.microservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExpcetionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = Exception.class )
	protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		        String bodyOfResponse = "Something Went Wrong!!";
		        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONTINUE, request);
		    }
}
