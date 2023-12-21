package com.ltp.gradesubmission.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import lombok.*;

@Entity
@Table(name ="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;



  

}
