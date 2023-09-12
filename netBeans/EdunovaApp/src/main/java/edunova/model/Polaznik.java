package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Polaznik extends Osoba {

    private String brojUgovora;
    
    @ManyToMany(mappedBy = "polaznici")
    private List<Grupa> grupe = new ArrayList<>();

    public List<Grupa> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupa> grupe) {
        this.grupe = grupe;
    }

    
    
    
    
    public Polaznik() {

    }

    public Polaznik(int sifra, String ime, String prezime, String oib, String email, String brojUgovora) {
        super(sifra, ime, prezime, oib, email);
        this.brojUgovora = brojUgovora;
    }

    public String getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

}
