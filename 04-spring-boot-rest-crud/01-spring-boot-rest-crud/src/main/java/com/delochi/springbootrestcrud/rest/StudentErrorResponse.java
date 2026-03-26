package com.delochi.springbootrestcrud.rest;

import org.springframework.http.HttpStatus;

public class StudentErrorResponse {
    private HttpStatus httpStatus;
    private String message;
    private long time;

    public StudentErrorResponse(HttpStatus httpStatus, String message, long time) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.time = time;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
