package com.management.airport.exception;


import com.management.airport.Entity.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ResponseException.class })
    public ResponseEntity<Object> handleAll(final ResponseException e, final WebRequest request) {
        logger.error("error", e);
        return new ResponseEntity<>(e.getResponseBody(), new HttpHeaders(), e.getResponseBody().getHttpStatus());
    }
    @ExceptionHandler(NumberFormatException.class)
        protected ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
            ResponseException responseException = new ResponseException("Invalid input. Please provide a valid numeric value","Invalid", HttpStatus.BAD_REQUEST);
            logger.error("error", responseException);
            return new ResponseEntity<>(responseException.getResponseBody(), new HttpHeaders(), responseException.getResponseBody().getHttpStatus());
        }
    }
