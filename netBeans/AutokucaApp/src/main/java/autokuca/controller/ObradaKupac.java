/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Kupac;
import autokuca.util.AutokucaException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author petar
 */
public class ObradaKupac extends Obrada<Kupac>{
    
    @Override
    public List<Kupac> read(){
        return session.createQuery("from Kupac k order by k.sifra desc",Kupac.class)
                .setMaxResults(10)
                .list();
    }
    
    public List<Kupac> read(String uvjet) {
        return read(uvjet,20);
    }
    
    public List<Kupac> read(String uvjet, int brojRezultata) {
        uvjet = uvjet==null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";
        
        List<Kupac> lista = session.createQuery("from Kupac k "
               + " where concat(k.ime,' ', k.prezime,' ') like :uvjet"
               + " order by k.prezime, k.ime",Kupac.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(brojRezultata)
               .list();
        
        // sloganje po hrvatskoj abecedi
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2)-> spCollator.compare(e1.getPrezime(), e2.getPrezime()));
        
       return lista;
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaBudzet();
        kontrolaIme();
        kontrolaPrezime();
        kontorlaDuplikata();
        //kontrolaBroja();
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
    
    private void kontrolaBroja() throws AutokucaException{
        
        String broj = entitet.getBroj_telefona();

        if (broj == null || broj.isEmpty()) {
            throw new AutokucaException("Broj telefona ne smije biti prazan.");
        }

        
        if (!broj.matches("^[0-9-()]*$")) {
            throw new AutokucaException("Broj telefona smije sadržavati samo brojeve, - i ()");
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
        List<Kupac> osobe= session.createQuery
        ("Select k from Kupac k where k.ime = :ime and k.prezime = :prezime and k.broj_telefona = :broj_telefona and k.budzet=:budzet"
                , Kupac.class)
                .setParameter("ime", entitet.getIme())
                .setParameter("prezime", entitet.getPrezime())
                .setParameter("broj_telefona", entitet.getBroj_telefona())
                .setParameter("budzet", entitet.getBudzet())
                .getResultList();
        if(!osobe.isEmpty()){
            throw new AutokucaException("Kupac postoji u bazi podataka");
        }
                     
                
    }
}
