/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Kupac;
import autokuca.util.autokucaException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author petar
 */
public class ObradaKupac extends Obrada<Kupac>{
    public List<Kupac> read(){
        return session.createQuery("from Kupac", Kupac.class).list();
    
    }

    @Override
    protected void kontrolaUnos() throws autokucaException {
        
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
        
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
       
    }
    
    private void kontrolaIme() throws autokucaException{
        if(entitet.getIme()==null){
            throw new autokucaException("Ime kupca ne smije biti null");
        }
        if(entitet.getIme().isEmpty()){
            throw new autokucaException("Ime kupca ne smije biti prazno");
        }
    }
    
}
