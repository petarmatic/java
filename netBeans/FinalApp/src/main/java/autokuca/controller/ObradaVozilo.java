/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Vozilo;
import autokuca.util.autokucaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaVozilo extends Obrada<Vozilo>{

    @Override
    public List<Vozilo> read() {
        return session.createQuery("from Vozilo", Vozilo.class).list();
    }

    @Override
    protected void kontrolaUnos() throws autokucaException {
        kontrolaCijena();
        kontrolaProdajnoMjesto();
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
    }

    private void kontrolaCijena() throws autokucaException{
        if(entitet.getCijena()==null){
            throw new autokucaException("Cijena mora biti definirana");
        }
        if (entitet.getCijena().compareTo(BigDecimal.ZERO) <= 0) {
        throw new autokucaException("Cijena mora biti veća od nule");
    }
        
    }

    private void kontrolaProdajnoMjesto() throws autokucaException{
        
    }
    
    
}
