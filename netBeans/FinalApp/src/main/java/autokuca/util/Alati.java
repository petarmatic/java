/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

import autokuca.model.Operater;


/**
 *
 * @author petar
 */
public class Alati { 
    public static final String NAZIV_APP = "Edunova APP";
    public static Operater OPERATER;

    public static String getOPERATER() {
        return OPERATER.getIme() + " " + OPERATER.getPrezime() + " (" + OPERATER.getUloga() + ")";
    }

   
    
    
}
