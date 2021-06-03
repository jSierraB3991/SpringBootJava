package com.example.Facturacion.shared.infrastructure.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Facturacion.infrastructure.rest.Response;

@ControllerAdvice
public class HandleExcetion 
{
	@Autowired
    private MessageSource messageSource;

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Response<String>> businessExcpetion(BusinessException businessException)
	{	
		return this.error(businessException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Response<String>> excpetion(Exception exception)
	{	
		return this.error(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Response<String>> notFoundException(NotFoundException exception)
	{	
		return this.error(exception, HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<Response<String>> error(Exception exception, HttpStatus httpStatus)
	{
		String[] array = exception.getMessage().split(":");
		String message = array[0];
		if(array.length == 2) {
			message = messageSource.getMessage(array[0], 
					null, LocaleContextHolder.getLocale());
			message = message + ":(" + array[1] + ")";
		}
		return new ResponseEntity<>(new Response<>(false, message), httpStatus);
	}
}
