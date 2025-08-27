package com.example.customexception;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class EmployeeNotfoundexception extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public EmployeeNotfoundexception(String message) {//"Employee not found with id: " + id
		super(message);
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
