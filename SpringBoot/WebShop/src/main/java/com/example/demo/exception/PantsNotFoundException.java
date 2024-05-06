package com.example.demo.exception;


public class PantsNotFoundException extends RuntimeException {

    public PantsNotFoundException(Long id) {
        super("Pants with id " + id + " not found");
    }
    
}
