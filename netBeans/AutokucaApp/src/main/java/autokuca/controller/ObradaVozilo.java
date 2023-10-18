/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Vozilo;
import autokuca.util.AutokucaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaVozilo extends Obrada<Vozilo>{

    @Override
    public List<Vozilo> read() {
        return session.createQuery("from Vozilo v order by v.sifra desc", Vozilo.class)
                .setMaxResults(50)
                .list();
    }
    
    public List<Vozilo> read(String uvjet){
        return read(uvjet,50);
        
    }
    
    public List<Vozilo> read(String uvjet, int brojRezultata) {
    uvjet = uvjet == null ? "" : uvjet;
    uvjet = uvjet.trim();
    uvjet = "%" + uvjet + "%";
    
    

    List<Vozilo> lista = session.createQuery("from Vozilo v"
            + " where concat(v.proizvodac, ' ', v.model) like :uvjet"
            + " order by v.proizvodac", Vozilo.class)
            .setParameter("uvjet", uvjet)
            .setMaxResults(brojRezultata)
            .list();
    return lista;
    }

    
    
    
   /* 
    @Override
    public List<Vozilo> read() {
        return session.createQuery("from Vozilo", Vozilo.class).list();
    }
*/

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaCijena();
       // kontrolaProdajnoMjesto();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
        if (entitet.getProdajnomjesto().getVozilo() !=null) {
        throw new AutokucaException("Vozilo se ne može obrisati jer je povezano s prodajnim mjestom");
    }
        
        
    }

    private void kontrolaCijena() throws AutokucaException{
        if(entitet.getCijena()==null){
            throw new AutokucaException("Cijena mora biti definirana");
        }
        if (entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0) {
        throw new AutokucaException("Cijena mora biti veća od nule");
    }
        
    }

    private void kontrolaProdajnoMjesto() throws AutokucaException{
        if(entitet.getProdajnomjesto().getVozilo()==null ||
                entitet.getProdajnomjesto().getVozilo().isEmpty()){
            throw new AutokucaException("Prodajno mjesto obavezno");
            
        }
        
    }
    
    private void kontrolaProizvodac() throws AutokucaException{
        if(entitet.getProizvodac()==null || entitet.getProizvodac().isEmpty()) {
            throw new AutokucaException("Proizvođač obavezno");
        }

    }
    
    private void kontrolaModel() throws AutokucaException{
        if(entitet.getModel()==null || entitet.getModel().isEmpty()){
            throw new AutokucaException("Model obavezno");
        }
        
    }
    
    private void kontorlaVIN() throws AutokucaException{
        if(entitet.getVIN()==null){
            throw new AutokucaException("VIN obavezno");
        }
        if(entitet.getVIN().isEmpty())
            throw new AutokucaException("VIN obavezno");
        
    }
    
    
    
    
}
