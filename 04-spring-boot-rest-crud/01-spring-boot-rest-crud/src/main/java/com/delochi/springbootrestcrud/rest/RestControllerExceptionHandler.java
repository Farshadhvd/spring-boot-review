package com.delochi.springbootrestcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StudentErrorResponse errorResponse = new StudentErrorResponse(httpStatus, e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGeneralException(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StudentErrorResponse errorResponse = new StudentErrorResponse(httpStatus, "You have entered a bad input as request.", System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
