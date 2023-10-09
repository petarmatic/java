/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Kupac;
import autokuca.util.AutokucaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaKupac extends Obrada<Kupac>{
    
     
    public List<Kupac> read() {
        return session.createQuery("from Kupac", Kupac.class).list();
    
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaBudzet();
        kontrolaIme();
        kontrolaPrezime();
        kontorlaDuplikata();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
        if(!entitet.getRacuni().isEmpty()){
            throw new AutokucaException("Kupac se ne može obrisati iz razloga zato što je na nekom računu");
        }
       
    }
    
    private void kontrolaIme() throws AutokucaException{
        if(entitet.getIme()==null){
            throw new AutokucaException("Ime kupca ne smije biti null");
        }
        if(entitet.getIme().isEmpty()){
            throw new AutokucaException("Ime kupca ne smije biti prazno");
        }
    }
    
    private void kontrolaBudzet() throws AutokucaException{
      
      
           if (entitet.getBudzet() == null) {
        throw new AutokucaException("Budžet mora biti definiran");
           }
        
    }

    private void kontrolaPrezime() throws AutokucaException {
         if(entitet.getPrezime()==null){
            throw new AutokucaException("Prezime mora biti definirano");
        }
        if(entitet.getPrezime().isEmpty()){
            throw new AutokucaException("Prezime kupca ne smije biti prazno");
        }
    }

    private void kontorlaDuplikata() throws AutokucaException {
        List<Kupac> osobe= session.createQuery("Select k from Kupac k where k.ime = :ime AND k.prezime = :prezime and k.broj_telefona = :broj_telefona", Kupac.class)
                .setParameter("ime", entitet.getIme())
                .setParameter("prezime", entitet.getPrezime())
                .setParameter("broj_telefona", entitet.getBroj_telefona())
                .getResultList();
        if(!osobe.isEmpty()){
            throw new AutokucaException("Kupac postoji u bazi podataka");
        }
                     
                
    }
}
