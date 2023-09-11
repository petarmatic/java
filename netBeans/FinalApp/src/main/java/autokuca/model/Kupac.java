package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Kupac extends Entitet {
        
	 
        
	private BigDecimal budzet;
	private String ime;
	private String prezime;
        
	 @OneToMany(mappedBy = "kupac")
        private List<Racun> racuni = new ArrayList<>();

        public List<Racun> getRacuni() {
            return racuni;
        }

        public void setRacuni(List<Racun> racuni) {
            this.racuni = racuni;
        }
         
         
         
         
	
	public Kupac() {
		super();
	}

	
	public Kupac(Integer sifra, BigDecimal budzet, String ime, String prezime) {
		super(sifra);
		this.budzet = budzet;
		this.ime = ime;
		this.prezime = prezime;
	}


	public BigDecimal getBudzet() {
		return budzet;
	}

	public void setBudzet(BigDecimal budzet) {
		this.budzet = budzet;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
    
        
	

	
}
