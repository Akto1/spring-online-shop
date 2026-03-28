package com.example.demo.Exceptions;

public class OrderValidationException extends RuntimeException{
    public OrderValidationException(String message){
        super(message);
    }
}
