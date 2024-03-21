/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishingstore.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


/**
 *
 * @author petar
 */

@MappedSuperclass
public abstract class Entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    Integer id;

    public Entity() {
    }

    public Entity(Integer id) {
        this.id = id;
    }

    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    
    
    
    
}
