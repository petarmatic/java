package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Jackets;
import com.example.demo.exception.JacketsNotFoundException;
import com.example.demo.repository.JacketsRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JacketsServiceImp implements JacketsService {
    private final JacketsRepository jacketsRepository;

    @Override
    public Jackets getJackets(Long id) {
        Optional<Jackets> jackets = jacketsRepository.findById(id);
        return unwrapJackets(jackets, id);

    }
  
 
    @Override
    public List<Jackets> getAllJackets() {
        Iterable<Jackets> jacketsIterable = jacketsRepository.findAll();
        return StreamSupport.stream(jacketsIterable.spliterator(), false)
                            .collect(Collectors.toList());  
    }


    @Override
    public Jackets saveJackets(Jackets jackets) {
        return jacketsRepository.save(jackets);
    }

    @Override
    public void deleteJackets(Long id) {
        jacketsRepository.deleteById(id);
    }

    static Jackets unwrapJackets(Optional<Jackets> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new JacketsNotFoundException(id);
    }
}
