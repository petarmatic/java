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
       return session.createQuery("from Polaznik",Polaznik.class).list();
    }
    
    public Polaznik readBySifra(int sifra){
        return session.get(Polaznik.class, sifra);
    }
    
    

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        super.kontrolaUnos(); 
         if(entitet.getOib()!=null && !entitet.getOib().isEmpty()){
            kontrolaOib();
        }
        kontrolaBrojUgovora();
    }

     @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaUnos();
    }
    
      @Override
    protected void kontrolaOib() throws EdunovaException {
        super.kontrolaOib(); 

        // ako postoji isti oib u bazi ne može se dodjeliti ovoj osobi
        List<Polaznik> lista = session.createQuery("from Polaznik p where p.oib =:uvjet "
                + " and p.sifra!=:sifra",Polaznik.class)
                .setParameter("uvjet", entitet.getOib())
                .setParameter("sifra", entitet.getSifra())
                .list();
        
        if(lista!=null && !lista.isEmpty()){
            throw new EdunovaException("OIB je zauzet!");
        }       
    }
    
    

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if(!entitet.getGrupe().isEmpty()){
            throw new EdunovaException("Ne možeš obrisati polaznika jer je na nekoj grupi");
        }
    }

    private void kontrolaBrojUgovora() throws EdunovaException {
        // Napisati kontrolu da broj ugovora u sebi mora sadržavati znak /
        if(entitet.getBrojUgovora()==null || !entitet.getBrojUgovora().contains("/") ){
            throw  new EdunovaException("Broj ugovora mora sadržavati znak /");
        }
    }
    
    
    
    
}
