/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Polaznik;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Katedra
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik>{

    @Override
    public List<Polaznik> read() {
       return sesssion.createQuery("from Polaznik",Polaznik.class).list();
    }
    
    

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        
    }
    
    
    
    
}
