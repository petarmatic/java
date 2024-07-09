package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jackets")


public class Pants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull(message = "Price cannot be blank")
    @Column(name = "price", nullable = false)
    private double price;
    


   


}
