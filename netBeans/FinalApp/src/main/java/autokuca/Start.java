/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package autokuca;

import autokuca.controller.ObradaOperater;
import autokuca.model.Operater;
import autokuca.util.HibernateUtil;
import autokuca.util.PocetniInsert;
import autokuca.view.Autorizacija;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 *
 * @author petar
 */
public class Start {

    public static void main(String[] args) {
        
       
        new Autorizacija().setVisible(true);
        HibernateUtil.getSession();
        new PocetniInsert();
    }
    
    private void lozinka(){
        Argon2 argon2 =  Argon2Factory.create(); 
        String hash = argon2.hash(10, 65536, 1, "oper".toCharArray());
        
        ObradaOperater oo= new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Petar");
        o.setPrezime("Matić");
        o.setEmail("pero@import.com");
        o.setLozinka("peroimport");
        o.setUloga("oper");
        
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }
       
}
