package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Jackets;
import com.example.demo.service.JacketsService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/jackets")
public class JacketsController {
    private final JacketsService jacketsService;

    @GetMapping("/{id}")
    public ResponseEntity <Jackets> getJackets(@PathVariable Long id) {
        return new ResponseEntity<>(jacketsService.getJackets(id), HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity <Jackets> saveJackets (@Valid @RequestBody Jackets jackets) {
    
        return new ResponseEntity<>(jacketsService.saveJackets(jackets), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJackets(@PathVariable Long id) {
        jacketsService.deleteJackets(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

