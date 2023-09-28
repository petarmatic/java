/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Osoba;
import edunova.util.Alati;
import edunova.util.EdunovaException;
import org.apache.commons.validator.routines.EmailValidator;


/**
 *
 * @author Katedra
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        
        kontrolaIme();
        kontrolaPrezime();
        kontrolaEmail();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
    
    }

    protected void kontrolaOib() throws EdunovaException {
       if(!Alati.isValjanOIB(entitet.getOib())){
           throw new EdunovaException("OIB nije valjan");
       }
    }
    private void kontrolaIme() throws EdunovaException  {
        if(entitet.getIme()==null || entitet.getIme().isEmpty()){
            throw new EdunovaException("Ime obavezno");
        }
    }
    private void kontrolaPrezime() throws EdunovaException  {
        if(entitet.getPrezime()==null || entitet.getPrezime().isEmpty()){
            throw new EdunovaException("Prezime obavezno");
        }
    }
    
    private void kontrolaEmail() throws EdunovaException  {
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(entitet.getEmail())){
             throw new EdunovaException("Email nije u dobrom formatu");
        }
    }
    
}
