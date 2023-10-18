/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.ProdajnoMjesto;
import autokuca.model.Prodavac;
import autokuca.util.AutokucaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaProdajnoMjesto extends Obrada<ProdajnoMjesto>{

    
    @Override
    public List<ProdajnoMjesto> read() {
        return session.createQuery("from ProdajnoMjesto p order by p.sifra desc", ProdajnoMjesto.class)
                .setMaxResults(50)
                .list();
    }
    
    public List<ProdajnoMjesto> read(String uvjet){
        return read(uvjet,50);
        
    }
    
    public List<ProdajnoMjesto> read(String uvjet, int brojRezultata) {
        uvjet = uvjet == null ? "" : uvjet;
        uvjet = uvjet.trim();
        uvjet = "%" + uvjet + "%";
    
        List<ProdajnoMjesto> lista = session.createQuery("from ProdajnoMjesto p"
            + " where concat(p.naziv, ' ', p.adresa) like :uvjet"
            + " order by p.naziv", ProdajnoMjesto.class)
            .setParameter("uvjet", uvjet)
            .setMaxResults(brojRezultata)
            .list();

    
    //Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
    //lista.sort((e1, e2)-> spCollator.compare(e1.getVozilo(), e2.getVozilo()));
    
        
   

    return lista;

               
}
    
    
    /*
    @Override
    public List<ProdajnoMjesto> read() {
        
        return session.createQuery("from ProdajnoMjesto", ProdajnoMjesto.class).list();
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaNaziv();
        kontrolaAdresa();
        kontrolaDuplikata();
        
        
    }

*/
     @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaNaziv();
        kontrolaAdresa();
        kontrolaDuplikata();
        
        
    }
    
    
    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
        Prodavac prodavac = entitet.getProdavac();
        if (prodavac != null || !prodavac.getProdajnoMjesto().isEmpty()) {
            throw new AutokucaException("Prodajno mjesto se ne može obrisati iz razloga što sadrži prodavača");
    }
    }
       
        
    

    private void kontrolaNaziv() throws AutokucaException{
        if(entitet.getNaziv()==null){
            throw new AutokucaException("Naziv mora biti definiran");
            }
        if(entitet.getNaziv().isEmpty()){
            throw new AutokucaException("Naziv smjera ne smije biti prazan");
        }
    }

    private void kontrolaAdresa() throws AutokucaException{
        String adresa = entitet.getAdresa();
    
        if (adresa == null) {
            throw new AutokucaException("Adresa mora biti definirana");
        }

        adresa = adresa.trim(); 

        if (adresa.isEmpty()) {
            throw new AutokucaException("Adresa ne smije biti prazna");
        }

        if (adresa.length() < 5) {
            throw new AutokucaException("Adresa mora imati barem 5 znakova");
        }
        
        char prvoSlovo = adresa.charAt(0);
        if (!Character.isUpperCase(prvoSlovo) && !Character.isDigit(prvoSlovo)) {
            throw new AutokucaException("Prvo slovo adrese mora biti veliko ili brojka");
    }

        
    }

   
    
     private void kontrolaDuplikata() throws AutokucaException {
        List<ProdajnoMjesto> mjesta= session.createQuery
        ("from ProdajnoMjesto pm where pm.naziv=:naziv and pm.adresa=:adresa and pm.prodavac=:prodavac", ProdajnoMjesto.class)
                .setParameter("naziv", entitet.getNaziv())
                .setParameter("adresa", entitet.getAdresa())
                .setParameter("prodavac", entitet.getProdavac())
                .getResultList();
        if(!mjesta.isEmpty()){
            throw new AutokucaException("Prodajno mjesto već postoji u bazi podataka");
        }
    }

    

    
}
    
    
    
    
    
