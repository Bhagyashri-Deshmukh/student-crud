package com.justcodeit.studentcrude.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ExceptionDetails> handleStudentNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.NOT_FOUND);		
	}
}
