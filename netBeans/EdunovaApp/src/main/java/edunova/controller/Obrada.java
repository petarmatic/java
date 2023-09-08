/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Entitet;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Katedra
 */
public abstract class Obrada<T extends Entitet>{
    
    protected T entitet;
    protected Session sesssion;
    public abstract List<T> read();
    protected abstract void kontrolaUnos() throws EdunovaException;
    protected abstract void kontrolaPromjena() throws EdunovaException;
    protected abstract void kontrolaBrisanje() throws EdunovaException;
    
    public Obrada(){
        sesssion = HibernateUtil.getSession();
    }
    
    public Obrada(T entitet){
        this();
        this.entitet=entitet;
    }
    
    public void create() throws EdunovaException{
        kontrolaNull();
        entitet.setSifra(null);
        kontrolaUnos();
        persist();
    }
    
    public void update() throws EdunovaException{
        kontrolaNull();
        kontrolaPromjena();
        persist();
    }
    
    public void delete() throws EdunovaException{
        kontrolaNull();
        kontrolaBrisanje();
        sesssion.beginTransaction();
        sesssion.remove(entitet);
        sesssion.getTransaction().commit();
    }
    
    private void persist(){
        sesssion.beginTransaction();
        sesssion.persist(entitet);
        sesssion.getTransaction().commit();
    }
    
    private void kontrolaNull() throws EdunovaException{
       if(entitet==null){
            throw new EdunovaException("Entitet je null");
        } 
       
    }
    

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
    
    
    
}
