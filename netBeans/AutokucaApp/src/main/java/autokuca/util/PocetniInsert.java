/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

import autokuca.controller.ObradaOperater;
import autokuca.model.Kupac;
import autokuca.model.Operater;
import autokuca.model.ProdajnoMjesto;
import autokuca.model.Prodavac;
import autokuca.model.Racun;
import autokuca.model.Vozilo;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import net.datafaker.Faker;
import org.hibernate.Session;



/**
 *
 * @author petar
 */
public class PocetniInsert {
    
    private static final int BROJ_KUPCA=2;
    private static final int BROJ_PRODAJNIHMJESTA=5;
    private static final int BROJ_PRODAVACA=2;
    private static final int BROJ_VOZILA=100;
    private static final int BROJ_RACUNA=100;
    
    private Faker faker;
   
    private Session session;
    private List<Prodavac> prodavaci;
    private List<ProdajnoMjesto> prodajno;
    private List<Kupac> kupci;
    private List<Vozilo> vozilo;
    
    public PocetniInsert(){
        faker= new Faker();
        session = HibernateUtil.getSession();
        prodavaci = new ArrayList<>();
        prodajno= new ArrayList<>();
        kupci= new ArrayList<>();
        session.getTransaction().begin();
        kreirajKupca();
        kreirajProdavaca();
        kreirajProdajnoMjesto();
        kreirajVozilo();
        kreirajRacun();
        session.getTransaction().commit();
        lozinka();
        
        
    }

    private void kreirajKupca() {
        Kupac k;
        for(int i=0;i<BROJ_KUPCA;i++){
            k=new Kupac();
            k.setBudzet(new BigDecimal(faker.number().numberBetween(1, 999999)));
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
            k.setBroj_telefona(faker.phoneNumber().cellPhone());
            session.persist(k);
            kupci.add(k);
   
        }
        
    }
    
    

    private void kreirajProdavaca() {
        Prodavac p;
        for(int i=0;i<BROJ_PRODAVACA;i++){
            p=new Prodavac();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            session.persist(p);
            prodavaci.add(p);
        }
    }
    
    
    private void kreirajProdajnoMjesto() {
        ProdajnoMjesto pm;
        List<Prodavac> p;
        for(int i=0;i<BROJ_PRODAJNIHMJESTA;i++){
            pm=new ProdajnoMjesto();
            pm.setNaziv(faker.company().name());
            pm.setAdresa(faker.address().fullAddress());
            pm.setProdavac(prodavaci.get(faker.number().numberBetween(0, BROJ_PRODAVACA-1)));
           session.persist(pm);
           prodajno.add(pm);
        }
    }
    private void kreirajVozilo() {
    Vozilo v;
    vozilo = new ArrayList<>(); // Initialize the list
    List<ProdajnoMjesto> pm;
    
    for (int i = 0; i < BROJ_VOZILA; i++) {
        v = new Vozilo();
        v.setCijena(new BigDecimal(faker.number().numberBetween(1, 999999)));
        v.setProdajnomjesto(prodajno.get(faker.number().numberBetween(0, BROJ_PRODAJNIHMJESTA - 1)));
        v.setProizvodac(faker.vehicle().make());
        v.setModel(faker.vehicle().model());
        v.setVIN(faker.vehicle().vin());
        session.persist(v);
        vozilo.add(v);
    }


     
     } 
    private void kreirajRacun() {
        Racun r;
        List<Kupac> k;
        List<Vozilo> v;
        List<Prodavac> p;
        for(int i=0;i<BROJ_RACUNA;i++){
            r= new Racun();
            r.setKupac(kupci.get(faker.number().numberBetween(0, BROJ_KUPCA-1)));
            r.setVozilo(vozilo.get(i));
            r.setProdavac(prodavaci.get(faker.number().numberBetween(0, BROJ_PRODAVACA-1)));
            session.persist(r);
            
            
            
        }
        
    }

   private static void lozinka(){
        Argon2 argon2 =  Argon2Factory.create(); 
        
        String hash = argon2.hash(10, 65536, 1, "peroimport".toCharArray());
        
        ObradaOperater oo= new ObradaOperater();
        Operater o = new Operater();
        o.setIme("Petar");
        o.setPrezime("Matić");
        o.setEmail("pero@import.com");
        o.setLozinka(hash);
        o.setUloga("oper");
        
        oo.setEntitet(o);
        
        try {
            oo.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }

    
    
    

    
}
