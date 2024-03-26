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
public class Nylon {
    
    
    private String name;
    private BigDecimal nylon_thickness;
    private BigDecimal price;

    public Nylon() {
    }

    public Nylon(String name, BigDecimal nylon_thickness, BigDecimal price) {
        this.name = name;
        this.nylon_thickness = nylon_thickness;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNylon_thickness() {
        return nylon_thickness;
    }

    public void setNylon_thickness(BigDecimal nylon_thickness) {
        this.nylon_thickness = nylon_thickness;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
