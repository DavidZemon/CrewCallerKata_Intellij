package com.uprr.training.shared.utils.spring.mvc;

import java.util.List;

import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * SampleGlobalExceptionHandler is a set of methods used by *all* controllers to handle specific error conditions. 
 * In order to function, it is required that somewhere in the Spring context:
 *   <!-- Common utilities, scan detected finds the the NCErrorResponseEntityExceptionHandler -->
 *	<context:component-scan base-package="com.uprr.ui.shared.utils.spring.mvc"/>
 * 
 * This particular implementation extends ResponseEntityExceptionHandler, but that is not required, as the @ControllerAdvice 
 * allows this class to intercept exceptions without extending that base class, if you prefer.
 *
 * @author Steven A. Wicklund (courtesy http://www.jayway.com/2013/02/03/improve-your-spring-rest-api-part-iii/)
 */

@ControllerAdvice
public class SampleGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(SampleGlobalExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage() + " ("+ex.getParameterName()+" : "+ex.getParameterType()+")";
		return handleException(ex, headers, new ErrorMessage(message));
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleException(ex, headers, createErrorMessage(ex.getFieldErrors()));
	}
	
	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorMessage message = new ErrorMessage(ex.getMessage());
		return handleException(ex, headers, message);
	}
	
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
            Object body, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        return handleException(ex, headers, new ErrorMessage(ex.getMessage()));        
    }

    private ResponseEntity<Object> handleException(Exception ex,
			HttpHeaders headers, ErrorMessage errorMessage) {
		LOG.warn("SampleGlobalExceptionHandler has intercepted an exception",ex);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<Object>(errorMessage, headers, HttpStatus.BAD_REQUEST);
	}
		
	private ErrorMessage createErrorMessage(List<FieldError> fieldErrors) {
		String[] messages = new String[fieldErrors.size()];
		for (int errIdx = 0; errIdx < messages.length; errIdx++) {
			FieldError fe = fieldErrors.get(errIdx);
			messages[errIdx] = fe.getField()+" : "+fe.getDefaultMessage();
		}
        return new ErrorMessage(messages);
	}

}
