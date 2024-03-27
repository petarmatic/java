/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishingstore.model;

import java.math.BigDecimal;

/**
 *
 * @author petar
 */
public class Rods extends Entity{
 
    public String name;
    public BigDecimal price;
    public BigDecimal length;

    public Rods() {
    }

    public Rods(String name, BigDecimal price, BigDecimal length) {
        this.name = name;
        this.price = price;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }
    
    
    
    
}
