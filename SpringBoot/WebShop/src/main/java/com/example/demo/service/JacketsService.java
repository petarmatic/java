package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Jackets;

public interface JacketsService {
    Jackets getJackets(Long id);
    List<Jackets> getAllJackets();
    Jackets saveJackets(Jackets jackets);
    void deleteJackets(Long id);
    

}
