/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Vozilo;
import autokuca.util.autokucaException;
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
    }

    @Override
    protected void kontrolaPromjena() throws autokucaException {
    }

    @Override
    protected void kontrolaBrisanja() throws autokucaException {
    }
    
    
}
