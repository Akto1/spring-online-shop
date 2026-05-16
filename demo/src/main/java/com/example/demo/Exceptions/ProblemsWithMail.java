package com.example.demo.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProblemsWithMail extends RuntimeException {
    public ProblemsWithMail(String message) {
        super(message);
    }
}
