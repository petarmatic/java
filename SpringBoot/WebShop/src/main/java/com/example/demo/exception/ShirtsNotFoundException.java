package com.example.demo.exception;

public class ShirtsNotFoundException extends RuntimeException {

    public ShirtsNotFoundException(Long id) {
        super(" Shirt with id " + id + " not found");
    }
    
}
