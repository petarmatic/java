/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Entitet;
import autokuca.util.HibernateUtil;
import autokuca.util.autokucaException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author petar
 */

public abstract class Obrada<T extends Entitet>{
    protected T entitet;
    protected Session session;   
    public abstract List<T> read();
    protected abstract void kontrolaUnos() throws autokucaException;
    protected abstract void kontrolaPromjena() throws autokucaException;
    protected abstract void kontrolaBrisanja() throws autokucaException;
    
    public Obrada(){
        session=HibernateUtil.getSession();
    }
    
    public void create() throws autokucaException{
        kontrolaNull();
        entitet.setSifra(null);
        kontrolaUnos();
        persist();
    }
    
    public void update() throws autokucaException{
        kontrolaNull();
        kontrolaPromjena();
        persist();
    }
    
    public void delete() throws autokucaException{
        kontrolaNull();
        kontrolaBrisanja();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }
    
    private void kontrolaNull() throws autokucaException{
        if(entitet==null){
            throw new autokucaException("Entitet je null");
        }
    }
    
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T Entitet) {
        this.entitet = Entitet;
    }
    
}
