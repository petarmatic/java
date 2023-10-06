/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.controller;

import autokuca.model.Entitet;
import autokuca.util.AutokucaException;
import autokuca.util.HibernateUtil;
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
    protected abstract void kontrolaUnos() throws AutokucaException;
    protected abstract void kontrolaPromjena() throws AutokucaException;
    protected abstract void kontrolaBrisanja() throws AutokucaException;
    
    public Obrada(){
        session=HibernateUtil.getSession();
    }
    
    public void create() throws AutokucaException{
        kontrolaNull();
        entitet.setSifra(null);
        kontrolaUnos();
        persist();
    }
    
    public void update() throws AutokucaException{
        kontrolaNull();
        kontrolaPromjena();
        persist();
    }
    
    public void delete() throws AutokucaException{
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
    
    private void kontrolaNull() throws AutokucaException{
        if(entitet==null){
            throw new AutokucaException("Entitet je null");
        }
    }
    
    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T Entitet) {
        this.entitet = Entitet;
    }

    public void refresh(){
        if(entitet!=null){
            session.refresh(entitet);
        }
    }   
   
}
