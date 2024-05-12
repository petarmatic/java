package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Shirts;

public interface ShirtsRepository extends CrudRepository<Shirts, Long> {


    
}
