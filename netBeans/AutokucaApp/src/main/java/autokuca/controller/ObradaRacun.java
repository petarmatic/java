/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Racun;
import autokuca.util.AutokucaException;
import java.text.Collator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author petar
 */
public class ObradaRacun extends Obrada<Racun>{

    @Override
    public List<Racun> read() {
        return session.createQuery("from Racun r order by r.sifra desc", Racun.class)
                .setMaxResults(50)
                .list();
    }
    
    public List<Racun> read(String uvjet) {
    uvjet = uvjet == null ? "" : uvjet;
    uvjet = uvjet.trim();
    uvjet = "%" + uvjet + "%";

    List<Racun> lista = session.createQuery("from Racun r"
            + " where concat(r.kupac, ' ', r.prodavac, ' ', r.vozilo) like :uvjet"
            + " order by r.vozilo, r.kupac", Racun.class)
            .setParameter("uvjet", uvjet)
            .setMaxResults(50)
            .list();
    Collator spCollator = Collator.getInstance(Locale.of("hr", "HR"));
        
    lista.sort((e1, e2)-> spCollator.compare(e1.getVozilo(), e2.getVozilo()));

    return lista;
}


    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaKupac();
        kontrolaProdavac();
        kontrolaVozilo();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
        
        if (!entitet.getKupac().getRacuni().isEmpty() || !entitet.getProdavac().getRacuni().isEmpty() ||
                entitet.getVozilo().getRacuni().isEmpty()) {
            throw new AutokucaException("Ne može se obrisati račun koji sadrži kupca, prodavača ili vozilo");
        }
        
    }

    private void kontrolaKupac() throws AutokucaException{
        if (entitet.getKupac() == null) {
            throw new AutokucaException("Kupac je obavezan.");
        }
    }

    private void kontrolaRacun() throws AutokucaException{
        kontrolaKupac();
        kontrolaVozilo();
        kontrolaProdavac();
     
    }

    private void kontrolaVozilo() throws AutokucaException{
        if(entitet.getVozilo()==null){
            throw new AutokucaException("Vozilo obavezno");
       }
    }

    private void kontrolaProdavac() throws AutokucaException{
        if (entitet.getProdavac() == null) {
            throw new AutokucaException("Prodavac je obavezan.");
        }
    }
    
}
