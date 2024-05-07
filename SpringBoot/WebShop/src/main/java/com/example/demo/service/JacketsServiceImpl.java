package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Jackets;
import com.example.demo.exception.JacketsNotFoundException;
import com.example.demo.repository.JacketsRepository;

import lombok.AllArgsConstructor;




@AllArgsConstructor
@Service
public class JacketsServiceImpl implements JacketsService{

    JacketsRepository jacketsRepository;

    @Override
    public Jackets getJackets(Long id) {
        Optional<Jackets> jackets= jacketsRepository.findById(id);
        return unwrapJackets(jackets,id);
    }
    

    @Override
    public Jackets saveJackets(Jackets jackets) {
        return jacketsRepository.save(jackets);
    }

    @Override
    public void deleteJackets(Long id) {
        jacketsRepository.deleteById(id);
    }

    static Jackets unwrapJackets(Optional<Jackets> entity, Long id){
        if(entity.isPresent()) return entity.get();
        else throw new JacketsNotFoundException(id);
    }


    
}
