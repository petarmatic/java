/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Racun;
import autokuca.util.AutokucaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradRacun extends Obrada<Racun>{

    @Override
    public List<Racun> read() {
        return session.createQuery("from racun", Racun.class).list();
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        kontrolaKupac();
        kontrolaRacun();
        kontrolaVozilo();
    }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
    }

    private void kontrolaKupac() throws AutokucaException{
    }

    private void kontrolaRacun() throws AutokucaException{
    }

    private void kontrolaVozilo() throws AutokucaException{
    }
    
}
