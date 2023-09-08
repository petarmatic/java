/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edunova;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edunova.controller.Obrada;
import edunova.controller.ObradaPolaznik;
import edunova.controller.ObradaSmjer;
import edunova.model.Polaznik;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import edunova.util.PocetniInsert;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Katedra
 */
public class Start {

    public static void main(String[] args) {

        // HibernateUtil.getSession();
        // new PocetniInsert();
       
        //System.out.println(new Gson().toJson(new ObradaSmjer().read()));
        
       
        ObradaPolaznik op = new ObradaPolaznik();
        Polaznik p = new Polaznik();
        p.setIme("Pero"); p.setPrezime("Perić");
        p.setOib("70159100491");
        
        op.setEntitet(p);
        
        try {
            op.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
        
        
        
        
    }
    
    private void primjerJSON(){
         String json = "[{\"naziv\":\"Schneider Aventinus\",\"cijena\":1010.00,\"upisnina\":98.00,\"trajanje\":246,\"verificiran\":true,\"sifra\":1},{\"naziv\":\"90 Minute IPA\",\"cijena\":917.00,\"upisnina\":74.00,\"trajanje\":344,\"verificiran\":true,\"sifra\":2},{\"naziv\":\"Trappistes Rochefort 8\",\"cijena\":991.00,\"upisnina\":76.00,\"trajanje\":294,\"verificiran\":false,\"sifra\":3},{\"naziv\":\"La Fin Du Monde\",\"cijena\":1065.00,\"upisnina\":101.00,\"trajanje\":97,\"verificiran\":true,\"sifra\":4},{\"naziv\":\"Orval Trappist Ale\",\"cijena\":1476.00,\"upisnina\":56.00,\"trajanje\":348,\"verificiran\":true,\"sifra\":5},{\"naziv\":\"Sierra Nevada Celebration Ale\",\"cijena\":1301.00,\"upisnina\":78.00,\"trajanje\":336,\"verificiran\":false,\"sifra\":6},{\"naziv\":\"Trappistes Rochefort 8\",\"cijena\":1236.00,\"upisnina\":109.00,\"trajanje\":214,\"verificiran\":true,\"sifra\":7},{\"naziv\":\"Stone Imperial Russian Stout\",\"cijena\":922.00,\"upisnina\":54.00,\"trajanje\":135,\"verificiran\":false,\"sifra\":8},{\"naziv\":\"Trappistes Rochefort 10\",\"cijena\":1536.00,\"upisnina\":57.00,\"trajanje\":300,\"verificiran\":true,\"sifra\":9},{\"naziv\":\"Chocolate St\",\"cijena\":1128.00,\"upisnina\":53.00,\"trajanje\":149,\"verificiran\":false,\"sifra\":10},{\"naziv\":\"Shakespeare Oatmeal\",\"cijena\":1157.00,\"upisnina\":107.00,\"trajanje\":212,\"verificiran\":false,\"sifra\":11},{\"naziv\":\"Double Bastard Ale\",\"cijena\":1155.00,\"upisnina\":96.00,\"trajanje\":181,\"verificiran\":true,\"sifra\":12},{\"naziv\":\"Prvi preko kontrola\",\"verificiran\":false,\"sifra\":13}]";

        List<Smjer> lista = new Gson().fromJson(json, 
                new TypeToken<List<Smjer>>(){}.getType());
        
        ObradaSmjer os = new ObradaSmjer();
        
        for(Smjer s : lista){
            os.setEntitet(s);
            try {
                os.create();
            } catch (EdunovaException ex) {
                System.out.println(ex.getPoruka());
            }
        }
    }
}
