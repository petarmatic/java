/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Polaznik;
import edunova.util.EdunovaException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Katedra
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik>{

     @Override
    public List<Polaznik> read() {
       return session.createQuery("from Polaznik p order by p.sifra desc",Polaznik.class)
               .setMaxResults(20)
               .list();
    }
    
    public List<Polaznik> read(String uvjet) {
        return read(uvjet, 20);
    }
    
     public List<Polaznik> read(String uvjet, int brojRezultata) {
        uvjet = uvjet==null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";
        
        List<Polaznik> lista = session.createQuery("from Polaznik p "
               + " where concat(p.ime,' ', p.prezime,' ',p.ime,' ',coalesce(p.oib,'')) like :uvjet"
               + " order by p.prezime, p.ime",Polaznik.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(brojRezultata)
               .setMaxResults(20)
               .list();
        
        // sloganje po hrvatskoj abecedi
        Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
        lista.sort((e1, e2)-> spCollator.compare(e1.getPrezime(), e2.getPrezime()));
        
       return lista;
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
