package com.example.demo.service;

import com.example.demo.entity.Pants;

public interface PantsServiceImpl {

    Pants getPants(Long id);
    Pants savePants(Pants pants);
    void deletePants(Long id);
    
}  
    

