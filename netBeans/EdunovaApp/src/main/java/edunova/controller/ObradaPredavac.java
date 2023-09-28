/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Predavac;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaPredavac extends ObradaOsoba<Predavac> {

    @Override
    public List<Predavac> read() {
        return session.createQuery("from Predavac",Predavac.class).list();
    }

    
     @Override
    protected void kontrolaUnos() throws EdunovaException {
        super.kontrolaUnos(); 
        if(entitet.getOib()!=null && !entitet.getOib().isEmpty()){
            kontrolaOib();
        }
        
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
       kontrolaUnos();
    }
    
    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        if(!entitet.getGrupe().isEmpty()){
            throw new EdunovaException("Ne možeš obrisati predavača jer predaje na nekoj grupi");
        }
    }
    
   @Override
    protected void kontrolaOib() throws EdunovaException {
        super.kontrolaOib(); 

        // ako postoji isti oib u bazi ne može se dodjeliti ovoj osobi
        List<Predavac> lista = session.createQuery("from Predavac p where p.oib =:uvjet "
                + " and p.sifra!=:sifra",Predavac.class)
                .setParameter("uvjet", entitet.getOib())
                .setParameter("sifra", entitet.getSifra())
                .list();
        
        if(lista!=null && !lista.isEmpty()){
            throw new EdunovaException("OIB je zauzet!");
        }       
    }    
    
    
    
}
