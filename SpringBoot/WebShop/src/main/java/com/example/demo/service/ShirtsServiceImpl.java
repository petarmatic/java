package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Shirts;
import com.example.demo.exception.ShirtsNotFoundException;
import com.example.demo.repository.ShirtsRepository;

public class ShirtsServiceImpl implements ShirtsService {

    ShirtsRepository shirtsRepository;

    @Override
    public Shirts getShirts(Long id) {
        Optional<Shirts> shirts= shirtsRepository.findById(id);
        return un
    }

    @Override
    public Shirts saveShirts(Shirts shirts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveShirts'");
    }

    @Override
    public void deleteShirts(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteShirts'");
    }

    static Shirts unwrapShirts(Optional<Shirts> entity,Long id){
        if(entity.isPresent()) return entity.get();
        else throw new ShirtsNotFoundException(id);
        
    } 
    
}
