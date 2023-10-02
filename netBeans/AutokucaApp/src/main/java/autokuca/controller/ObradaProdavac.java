/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Prodavac;
import autokuca.util.AutokucaException;
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
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaIme();
        kontrolaPrezime();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
        
        if(!entitet.getRacuni().isEmpty() || !entitet.getProdajnoMjesto().isEmpty())
            throw new AutokucaException("Ne može se obrisati račun, zato što je odredio neki račun ili je na nekom prodajnom mjestu");
    }

    private void kontrolaIme() throws AutokucaException{
        if(entitet.getIme()==null){
            throw new AutokucaException("Ime mora biti definirano");
        }
        if(entitet.getIme().isEmpty()){
            throw new AutokucaException("Ime ne smije biti prazno");
        }
        if (!Character.isUpperCase(entitet.getIme().charAt(0))) {
        throw new AutokucaException("Prvo slovo imena mora biti veliko");
        }
        
    }

    private void kontrolaPrezime() throws AutokucaException{
        if(entitet.getPrezime()==null){
            throw new AutokucaException("Prezime mora biti definirano");
        }
        if(entitet.getPrezime().isEmpty()){
            throw new AutokucaException("Prezime ne smije biti prazno");
        }
        if (!Character.isUpperCase(entitet.getPrezime().charAt(0))) {
        throw new AutokucaException("Prvo slovo prezimena mora biti veliko");
    }
    }
    
    
}
