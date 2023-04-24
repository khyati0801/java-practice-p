package com.onerivet.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.Payload.Apiresponse;

@RestControllerAdvice
public class GlobalExceptionHandler  extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public Apiresponse resournceNotFoundHandler(ResourceNotFoundException ex) {
		
		String message=ex.getMessage();
		LocalDateTime now=LocalDateTime.now();
		Apiresponse apiresponce=new Apiresponse(message,now);
		return apiresponce;
		
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String,String> errMap =new HashMap<String, String>();
	
	 ex.getBindingResult().getAllErrors().forEach(error -> {
		 String field = ((FieldError)error).getField();
		 String defaultMessage = error.getDefaultMessage();
		 errMap.put(field, defaultMessage);
	 });
    return errMap;
	 
	}

}
