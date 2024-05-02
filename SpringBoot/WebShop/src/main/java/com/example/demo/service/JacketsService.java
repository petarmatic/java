package com.example.demo.service;

import com.example.demo.entity.Jackets;

public interface JacketsService {
    Jackets getJackets(Long id);
    Jackets saveJackets(Jackets jackets);
    void deleteJackets(Long id);
    

}
