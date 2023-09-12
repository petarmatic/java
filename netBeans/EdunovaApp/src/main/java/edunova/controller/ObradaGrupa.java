/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Grupa;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author petar
 */

    public class ObradaGrupa extends Obrada<Grupa>{

    @Override
    public List<Grupa> read() {
        return session.createQuery("from Grupa",Grupa.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        
    }
    }
    

