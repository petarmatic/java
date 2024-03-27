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
public class Groundbaits extends Entity{
    
    
    private String type;
    private BigDecimal price;

    public Groundbaits() {
    }

    public Groundbaits(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
    
}
