package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Grupa extends Entitet {

    private String naziv;
    @ManyToOne
    private Smjer smjer;
    private Integer maxpolaznika;
    @ManyToOne
    private Predavac predavac;
    private Date datumPocetka;

    @ManyToMany
    private List<Polaznik> polaznici;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Smjer getSmjer() {
        return smjer;
    }

    public void setSmjer(Smjer smjer) {
        this.smjer = smjer;
    }

    public Integer getMaxpolaznika() {
        return maxpolaznika;
    }

    public void setMaxpolaznika(Integer maxpolaznika) {
        this.maxpolaznika = maxpolaznika;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public List<Polaznik> getPolaznici() {
        return polaznici;
    }

    public void setPolaznici(List<Polaznik> polaznici) {
        this.polaznici = polaznici;
    }
    
    @Override
    public String toString() {
      
        StringBuilder sb = new StringBuilder();
        
        if(getNaziv()==null ){
            sb.append("Grupa bez naziva, ");
            sb.append(String.valueOf(getSifra()));
        } else if(getNaziv().length()>10){
            sb.append(getNaziv().substring(0,10));
            sb.append("...");
        }else{
            sb.append(getNaziv());
        }
        
        if(getSmjer()!=null && getSmjer().getNaziv()!=null && !getSmjer().getNaziv().isEmpty()){
            sb.append(" [");
            sb.append(getSmjer().getNaziv());
            sb.append("]");
        }
        
        return sb.toString();
        
    }

}
