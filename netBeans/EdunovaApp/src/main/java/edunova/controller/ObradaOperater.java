/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edunova.model.Operater;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author petar
 */
public class ObradaOperater extends ObradaOsoba<Operater>{
    
    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater",Operater.class).list();
    }
    
    
    public Operater autoriziraj(String email, String lozinka){
        Operater o;
        
        try {
            o = session.createQuery("from Operater o where o.email=:email",Operater.class)
                    .setParameter("email", email).getSingleResult();
             Argon2 argon2 = Argon2Factory.create();
              
              return argon2.verify(o.getLozinka(), lozinka.toCharArray()) ? o : null;
              
        } catch (Exception e) {
            return null;
        
        }
        
        
        
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
    }
    
}
