/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.ProdajnoMjesto;
import autokuca.util.autokucaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaProdajnoMjesto extends Obrada<ProdajnoMjesto>{

    @Override
    public List<ProdajnoMjesto> read() {
        
        return session.createQuery("from Prodajno Mjesto", ProdajnoMjesto.class).list();
    }

    @Override
    protected void kontrolaUnos() throws autokucaException {
        kontrolaNaziv();
        kontrolaAdresa();
        kontrolaProdavac();
        
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
        
    }

    private void kontrolaNaziv() throws autokucaException{
        if(entitet.getNaziv()==null){
            throw new autokucaException("Naziv mora biti definiran");
            }
        if(entitet.getNaziv().isEmpty()){
            throw new autokucaException("Naziv smjera ne smije biti prazan");
        }
    }

    private void kontrolaAdresa() throws autokucaException{
        String adresa = entitet.getAdresa();
    
        if (adresa == null) {
            throw new autokucaException("Adresa mora biti definirana");
        }

        adresa = adresa.trim(); 

        if (adresa.isEmpty()) {
            throw new autokucaException("Adresa ne smije biti prazna");
        }

        if (adresa.length() < 5) {
            throw new autokucaException("Adresa mora imati barem 5 znakova");
        }
        
    }

    private void kontrolaProdavac() throws autokucaException{
    }
    
    
}
