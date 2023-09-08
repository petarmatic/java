/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Prodavac;
import autokuca.util.autokucaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaProdavac extends Obrada<Prodavac>{

    @Override
    public List<Prodavac> read() {
        return session.createQuery("from Prodavac", Prodavac.class).list();
    }

    @Override
    protected void kontrolaUnos() throws autokucaException {
        kontrolaIme();
        kontrolaPrezime();
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
    }

    private void kontrolaIme() throws autokucaException{
        if(entitet.getIme()==null){
            throw new autokucaException("Ime mora biti definirano");
        }
        if(entitet.getIme().isEmpty()){
            throw new autokucaException("Ime ne smije biti prazno");
        }
    }

    private void kontrolaPrezime() throws autokucaException{
        if(entitet.getPrezime()==null){
            throw new autokucaException("Prezime mora biti definirano");
        }
        if(entitet.getPrezime().isEmpty()){
            throw new autokucaException("Prezime ne smije biti prazno");
        }
    }
    
    
}
