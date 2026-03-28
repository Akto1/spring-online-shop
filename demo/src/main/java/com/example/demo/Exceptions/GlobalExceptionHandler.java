package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderValidationException.class)
    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(OrderValidationException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","CreateOrderError");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(ProductNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","ProductNotFoundError");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(UserNotFoundException ex){
        Map<String,String> error = new HashMap<>();
        error.put("error","CreateUserError");
        error.put("message",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
