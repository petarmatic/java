/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package autokuca;

import autokuca.controller.ObradaOperater;
import autokuca.model.Operater;
import autokuca.util.HibernateUtil;
import autokuca.util.PocetniInsert;

/**
 *
 * @author petar
 */
public class Start {

    public static void main(String[] args) {
        
       
    
        HibernateUtil.getSession();
          new PocetniInsert();
    }
       
}
