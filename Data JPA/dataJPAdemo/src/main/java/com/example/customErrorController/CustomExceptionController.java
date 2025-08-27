package com.example.customErrorController;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.customexception.EmployeeNotfoundexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestControllerAdvice
public class CustomExceptionController {// advice given by RestcontrollerAdvice //user defined error controller
	//this is Custom Exception Controller
	//basic error controller wont be used after creating our own controller
	
	@ExceptionHandler(EmployeeNotfoundexception.class)
	public errorinfo handleException(EmployeeNotfoundexception e) {
		return new errorinfo(e.getMessage(),"/employees/{id}",java.time.LocalDateTime.now().toString(),404);
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public errorinfo handleException(Exception e) {
		return new errorinfo(e.getMessage(),"/employees/{id}",java.time.LocalDateTime.now().toString(),400);
	}
	

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class errorinfo{
	public String message;
	public String path;
	public String timestamp;
	public int status;
	
}
