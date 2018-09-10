package com.sango.microservice.microservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CommonExpcetionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = Exception.class )
	protected ResponseEntity<Object> handleAllException(RuntimeException ex, WebRequest request) {
		        CommonExceptionResponse commonExceptionRespose = 
		        		new CommonExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		        return new ResponseEntity<Object>(commonExceptionRespose,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NoUsersFoundException.class )
	protected ResponseEntity<Object> handleNoUsersFoundException(NoUsersFoundException ex, WebRequest request) {
		        CommonExceptionResponse commonExceptionRespose = 
		        		new CommonExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		        return new ResponseEntity<Object>(commonExceptionRespose,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class )
	protected ResponseEntity<Object> UserNotFoundExceptionException(UserNotFoundException ex, WebRequest request) {
		        CommonExceptionResponse commonExceptionRespose = 
		        		new CommonExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		        return new ResponseEntity<Object>(commonExceptionRespose,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			CommonExceptionResponse commonExceptionRespose = new CommonExceptionResponse(new Date(),ex.getMessage(),
																ex.getBindingResult().toString());
		return new ResponseEntity<Object>(commonExceptionRespose,HttpStatus.BAD_REQUEST);
	}
}
