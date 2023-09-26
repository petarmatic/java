package edunova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Smjer extends Entitet {

    @Column(nullable = false)
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal upisnina;
    private Integer trajanje;
    @Column(columnDefinition = "boolean")
    private Boolean verificiran;
    
    @OneToMany(mappedBy = "smjer")
    private List<Grupa> grupe = new ArrayList<>();

    public Smjer() {

    }

    public Smjer(Integer sifra, String naziv, BigDecimal cijena, BigDecimal upisnina, Integer trajanje, boolean verificiran) {
        super(sifra);
        this.naziv = naziv;
        this.cijena = cijena;
        this.upisnina = upisnina;
        this.trajanje = trajanje;
        this.verificiran = verificiran;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public BigDecimal getUpisnina() {
        return upisnina;
    }

    public void setUpisnina(BigDecimal upisnina) {
        this.upisnina = upisnina;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public Boolean isVerificiran() {
        return verificiran;
    }

    public void setVerificiran(Boolean verificiran) {
        this.verificiran = verificiran;
    }

    public List<Grupa> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupa> grupe) {
        this.grupe = grupe;
    }
    
    @Override
    public String toString() {
        return naziv;
    }
    

}
