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
        return session.createQuery("from Vozilo", Vozilo.class).list();
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaCijena();
        kontrolaProdajnoMjesto();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
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
        
    }
    
    
}
