/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishingstore.controller;

import fishingstore.model.Entity;
import fishingstore.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author petar
 */
public abstract class Processing<T extends Entity> {
     protected T entity;
    protected Session session; 
     public abstract List<T> read();
     
     
      public Processing(){
        session=HibernateUtil.getSession();
      }
      
      
      
      
      
       private void persist(){
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
      
      
      
      
      
}
