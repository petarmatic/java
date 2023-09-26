/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Grupa;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Petar
 */
public class ObradaSmjer extends Obrada<Smjer>{

    public ObradaSmjer() {
        super();
    }
    
    public ObradaSmjer(Smjer s) {
        super(s);
    }
    
    

    @Override
    public List<Smjer> read() {
        // HQL https://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
        return session.createQuery("from Smjer", Smjer.class).list();
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaNaziv();
        nadopunaNaziva();
        kontrolaCijena();
        
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
      kontrolaCijena();
      kontrolaNaziv();
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
       if(!entitet.getGrupe().isEmpty()){
           
           StringBuilder sb = new StringBuilder();
           sb.append("Smjer se ne može obrisati jer ima grupe (");
           for(Grupa g : entitet.getGrupe()){
               sb.append(g.getNaziv());
               sb.append(", ");
           }
           // DZ: Očistiti zadnji zarez
           sb.append(")");
           
           
            throw new EdunovaException(sb.toString());
       }
    }

    private void kontrolaNaziv() throws EdunovaException{
        if(entitet.getNaziv()==null){
            throw new EdunovaException("Naziv smjera mora biti definiran");
        }
        if(entitet.getNaziv().isEmpty()){
            throw new EdunovaException("Naziv smjera ne smije biti prazan");
        }
    }

    private void kontrolaCijena() throws EdunovaException {
       
        var c = entitet.getCijena();
        if(c==null){
            return;
        }
        
        if(c.compareTo(BigDecimal.ZERO)<=0 ||
                c.compareTo(new BigDecimal(10000))>0){
            throw new EdunovaException("Ako je cijena postavljena mora biti veća od 0 i manja ili jednaka 10000");
        }
        
    }
    
    private void nadopunaNaziva(){
         List<Smjer> lista = session.createQuery("from Smjer s where s.naziv like :uvjet",Smjer.class)
                .setParameter("uvjet", entitet.getNaziv() + "%")
                .list();
        
        if(lista!=null && !lista.isEmpty()){
            entitet.setNaziv(entitet.getNaziv() + " (" + (lista.size()) + ")");
        }
    }
    
}
