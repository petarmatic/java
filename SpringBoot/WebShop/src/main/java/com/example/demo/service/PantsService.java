package com.example.demo.service;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Pants;
import com.example.demo.exception.PantsNotFoundException;
import com.example.demo.repository.PantsRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class PantsService implements PantsServiceImpl{

    PantsRepository pantsRepository;

    @Override
    public Pants getPants(Long id) {
        Optional<Pants> pants= pantsRepository.findById(id);
        return unwrapPants(pants,id);
    }

    @Override
    public Pants savePants(Pants pants) {
        
        throw new UnsupportedOperationException("Unimplemented method 'savePants'");
    }

    @Override
    public void deletePants(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletePants'");
    }

   static Pants unwrapPants(Optional<Pants> entity, Long id){
        if(entity.isPresent()) return entity.get();
        else throw new PantsNotFoundException(id);
   }
    
}
