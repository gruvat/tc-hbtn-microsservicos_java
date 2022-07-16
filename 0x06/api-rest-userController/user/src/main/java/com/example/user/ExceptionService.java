package com.example.user;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserErrorResponse;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(UserIdException.class)
    public ResponseEntity<UserErrorResponse> exceptionHandler(UserIdException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setTimestamp(new Date());
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage("You have entered "+err.getMessage()+" invalid ID.");

        return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNameException.class)
    public ResponseEntity<UserErrorResponse> exceptionHandler(UserNameException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setTimestamp(new Date());
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage("You have entered "+err.getMessage()+" invalid USERNAME.");

        return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(CPFException.class)
    public ResponseEntity<UserErrorResponse> exceptionHandler(CPFException err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setTimestamp(new Date());
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage("You have entered CPF "+err.getMessage()+" invalid.");

        return new ResponseEntity<>(uer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserErrorResponse> exceptionHandler(Exception err) {
        UserErrorResponse uer = new UserErrorResponse();
        uer.setTimestamp(new Date());
        uer.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        uer.setMessage("Internal error.");

        return new ResponseEntity<>(uer, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
