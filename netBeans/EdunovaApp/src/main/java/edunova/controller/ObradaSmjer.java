/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaSmjer extends Obrada<Smjer>{

    @Override
    public List<Smjer> read() {
        
        return session.createQuery("from Smjer", Smjer.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
      kontrolaNaziv();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaBrisanja() throws EdunovaException {
    }

    private void kontrolaNaziv() throws EdunovaException{
        //if(Entitet.getNaziv()==null|| Entitet.getNaziv().isEmpty)
        //sout== Naziv smjera obavezno
        if(entitet.getNaziv()==null){
            throw new EdunovaException("Naziv smjera ne smije biti null");
        }
        if(entitet.getNaziv().isEmpty()){
            throw new EdunovaException("Naziv smjera ne smije biti prazan");
        }
            
    }
    
}
