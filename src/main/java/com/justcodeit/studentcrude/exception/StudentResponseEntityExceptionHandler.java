package com.justcodeit.studentcrude.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// @ControllerAdvice is usedso that this exception class can be used for all controllers globally
@ControllerAdvice
public class StudentResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	// @ExceptionHandler is used to specify to which exception this method should be executed
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
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		String msg = ex.getFieldError().getDefaultMessage();
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), msg,request.getDescription(false));
		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.BAD_REQUEST);	

		//return handleExceptionInternal(ex, null, headers, status, request);
	}
}
