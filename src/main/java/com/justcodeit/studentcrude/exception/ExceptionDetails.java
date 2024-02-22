package com.justcodeit.studentcrude.exception;

import java.time.LocalDateTime;


// this class is created to write our own exception message
public class ExceptionDetails {

	private LocalDateTime time;
	private String message;
	private String details;

	public ExceptionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionDetails(LocalDateTime time, String message, String details) {
		super();
		this.time = time;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
