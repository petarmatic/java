/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Operater;
import autokuca.util.AutokucaException;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    public Operater autoriziraj(String email, String lozinka) {
        Operater o;

        try {
            o = session.createQuery("from Operater o where o.email=:email", Operater.class)
                    .setParameter("email", email).getSingleResult();
            Argon2 argon2 = Argon2Factory.create();

            return argon2.verify(o.getLozinka(), lozinka.toCharArray()) ? o : null;

        } catch (Exception e) {
            return null;

        }
    }

    @Override
    protected void kontrolaUnos() throws AutokucaException {
        if (entitet.getIme() == null || entitet.getIme().isEmpty()) {
            throw new AutokucaException("Ime obavezno");
        }
        if (entitet.getPrezime() == null || entitet.getPrezime().isEmpty()) {
            throw new AutokucaException("Prezimeobavezno");
        }
        if (entitet.getEmail() == null || entitet.getEmail().isEmpty()) {
            throw new AutokucaException("Email obavezno");
        }
         if (!entitet.getEmail().contains("@")) {
            throw new AutokucaException("Email mora sadržavati @");
        }
        if (entitet.getLozinka() == null || entitet.getLozinka().isEmpty()) {
            throw new AutokucaException("Lozinka obavezno");
        }
        if (entitet.getUloga() == null || entitet.getUloga().isEmpty()) {
            throw new AutokucaException("Uloga obavezno");
        }
        
    }
      private void kontrolaEmail() throws AutokucaException {
        if (!entitet.getEmail().contains("@")) {
            throw new AutokucaException("Email operatera mora sadržavati @");
        }
      }

    @Override
    protected void kontrolaPromjena() throws AutokucaException {
        kontrolaUnos();
    }

    @Override
    protected void kontrolaBrisanja() throws AutokucaException {
    }

}
