package com.myit.settlement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	  @ExceptionHandler(value = SettlementException.class)
	  public ResponseEntity<ErrorMessage> resourceNotFoundException (SettlementException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(ex.getErrorCode(), ex.getErrorDesc());
	    
	    return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(value = {Exception.class})
	  public ResponseEntity<ErrorMessage> generalException (SettlementException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(ex.getErrorCode(), ex.getErrorDesc());
	    
	    return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
