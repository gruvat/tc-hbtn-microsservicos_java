package com.example.calculator.service;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.calculator.Exception.ErrorResponse;

@ControllerAdvice
public class ExceptionService {
    
    @ExceptionHandler(RuntimeException.class) 
    public ResponseEntity<ErrorResponse> runtimeHandler(RuntimeException ex) {
        ErrorResponse err = new ErrorResponse();
        err.setTimestamp(new Date());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<ErrorResponse> runtimeHandler(Exception ex) {
        ErrorResponse err = new ErrorResponse();
        err.setTimestamp(new Date());
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setMessage(ex.getMessage());

        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
