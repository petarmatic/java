/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

/**
 *
 * @author petar
 */
public class AutokucaException extends Exception{
    
    private String poruka;

    public AutokucaException(String poruka) {
        super(poruka);
        this.poruka = poruka;
    }

    

    public String getPoruka() {
        return poruka;
    }
    
    

    
    
}
