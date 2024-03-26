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
public class Reels {
    
    private String name;
    private BigDecimal price;
    private BigDecimal line_capacity;

    public Reels() {
    }

    public Reels(String name, BigDecimal price, BigDecimal line_capacity) {
        this.name = name;
        this.price = price;
        this.line_capacity = line_capacity;
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

    public BigDecimal getLine_capacity() {
        return line_capacity;
    }

    public void setLine_capacity(BigDecimal line_capacity) {
        this.line_capacity = line_capacity;
    }
    
    
    
    
}
