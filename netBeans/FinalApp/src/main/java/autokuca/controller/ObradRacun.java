/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Racun;
import autokuca.util.autokucaException;
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
    protected void kontrolaUnos() throws autokucaException {
        kontrolaKupac();
        kontrolaRacun();
        kontrolaVozilo();
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
    }

    private void kontrolaKupac() throws autokucaException{
    }

    private void kontrolaRacun() throws autokucaException{
    }

    private void kontrolaVozilo() throws autokucaException{
    }
    
}
