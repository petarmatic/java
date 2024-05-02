package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Jackets;

public interface JacketsRepository extends CrudRepository<Jackets, Long> {
    
}
