package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Jackets;
import com.example.demo.repository.JacketsRepository;

import lombok.AllArgsConstructor;




@AllArgsConstructor
@Service
public class JacketsServiceImpl implements JacketsService{

    JacketsRepository jacketsRepository;

    @Override
    public Jackets getJackets(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJackets'");
    }

    @Override
    public Jackets saveJackets(Jackets jackets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveJackets'");
    }

    @Override
    public void deleteJackets(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteJackets'");
    }

    


    
}
