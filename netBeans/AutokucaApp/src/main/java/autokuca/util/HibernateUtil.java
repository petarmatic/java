/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author petar
 */
public class HibernateUtil {
    
    
    private static Session session=null;
    
    private HibernateUtil(){
        session= new Configuration().configure().buildSessionFactory().openSession();
    }
    
    public static Session getSession(){
        if(session==null){
            new HibernateUtil();
        }
        return session;
    }
    
        
}
    
    

