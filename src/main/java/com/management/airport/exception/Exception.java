package com.management.airport.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;

public class Exception {
    private static final String EMPLOYEE_NOT_FOUND_MSG_KEY = "EmployeeNotExisted";
    private static final String EMPLOYEE_NOT_FOUND_MSG = "Employee Not Found";
    private static final String FLIGHT_NOT_FOUND_MSG_KEY = "FlightNotExisted";
    private static final String FLIGHT_NOT_FOUND_MSG = "Flight Not Found";
    private static final String CERTIFICATION_NOT_FOUND_MSG_KEY = "CertificationNotExisted";
    private static final String CERTIFICATION_NOT_FOUND_MSG = "Certification Not Found";
    private static final String AIRPLANE_NOT_FOUND_MSG_KEY = "AirplaneNotExisted";
    private static final String AIRPLANE_NOT_FOUND_MSG = "Airplane Not Found";

    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }
    public static ResponseException badRequest(String messageKey, String message){
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }
    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseException EmployeeNotFound() {
        return notFound(EMPLOYEE_NOT_FOUND_MSG_KEY, EMPLOYEE_NOT_FOUND_MSG);
    }
    public static ResponseException EmployeeBadRequest(){
        return badRequest("BadRequest","Id is null");
    }
    public static ResponseException FlightNotFound(){
        return notFound(FLIGHT_NOT_FOUND_MSG_KEY, FLIGHT_NOT_FOUND_MSG);
    }
    public static ResponseException FlightBadRequest(){
        return badRequest("BadRequest","Flight Is Null or Blank");
    }
    public static ResponseException CertificatoinNotFound(){
        return notFound(CERTIFICATION_NOT_FOUND_MSG_KEY, CERTIFICATION_NOT_FOUND_MSG);
    }
    public static ResponseException CertificationBadRequest(){
        return badRequest("BadRequest","Certification is Null or Blank");
    }
    public static ResponseException AirplaneNotFound(){
        return notFound(AIRPLANE_NOT_FOUND_MSG_KEY, AIRPLANE_NOT_FOUND_MSG);
    }
    public static ResponseException AirplaneBadRequest(){
        return badRequest("BadRequest","Airplane is null or blank");
    }

}
