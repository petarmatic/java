package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pants;
import com.example.demo.service.PantsService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;




@AllArgsConstructor
@RestController
@RequestMapping("/pants")


public class PantsController {
    PantsService pantsService;

    @GetMapping("/{id}")
    public ResponseEntity <Pants> getJackets(@PathVariable Long id) {
        return new ResponseEntity<>(pantsService.getPants(id), HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity <Pants> saveJackets (@Valid @RequestBody Pants pants) {
    
        return new ResponseEntity<>(pantsService.savePants(pants), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePants(@PathVariable Long id) {
        pantsService.deletePants(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
