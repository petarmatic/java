package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Pants;

public interface PantsRepository extends CrudRepository<Pants,Long> {
    
}
