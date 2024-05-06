package com.example.demo.exception;

public class JacketsNotFoundException extends RuntimeException{

    public JacketsNotFoundException(Long id) {
        super("Jackets with id " + id + " not found");
    }
    
}
