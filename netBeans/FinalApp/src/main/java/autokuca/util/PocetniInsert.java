/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autokuca.util;

import autokuca.model.Kupac;
import autokuca.model.ProdajnoMjesto;
import autokuca.model.Prodavac;
import autokuca.model.Racun;
import autokuca.model.Vozilo;
import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;



/**
 *
 * @author petar
 */
public class PocetniInsert {
    
    private static final int BROJ_KUPCA=2;
    private static final int BROJ_PRODAJNIHMJESTA=5;
    private static final int BROJ_PRODAVACA=2;
    private static final int BROJ_VOZILA=10;
    private static final int BROJ_RACUNA=10000;
    
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
        
        
    }

    private void kreirajKupca() {
        Kupac k;
        for(int i=0;i<BROJ_KUPCA;i++){
            k=new Kupac();
            k.setBudzet(new BigDecimal(faker.number().numberBetween(1, 999999)));
            k.setIme(faker.name().firstName());
            k.setPrezime(faker.name().lastName());
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
            pm.setNaziv(faker.name().name());
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
            r.setVozilo(vozilo.get(faker.number().numberBetween(0, BROJ_VOZILA-1)));
            r.setProdavac(prodavaci.get(faker.number().numberBetween(0, BROJ_PRODAVACA-1)));
            session.persist(r);
            
            
            
        }
        
    }

   

    
    
    

    
}
