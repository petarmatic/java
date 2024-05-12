package com.example.demo.service;

import com.example.demo.entity.Shirts;

public interface ShirtsService {

    Shirts getShirts(Long id);
    Shirts saveShirts(Shirts shirts);
    void deleteShirts(Long id);
    

    
    
}
