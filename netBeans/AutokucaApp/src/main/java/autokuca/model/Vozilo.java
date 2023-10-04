package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vozilo extends Entitet{
	private BigDecimal cijena;
        @ManyToOne
	private ProdajnoMjesto prodajnomjesto;
        private String proizvodac;
        private String model;
        private String VIN;
	
	 @OneToMany(mappedBy = "vozilo")
        private List<Racun> racuni = new ArrayList<>();

        public List<Racun> getRacuni() {
            return racuni;
        }

        public void setRacuni(List<Racun> racuni) {
            this.racuni = racuni;
        }

        public Vozilo(BigDecimal cijena, ProdajnoMjesto prodajnomjesto, String proizvodac, String model, String VIN, Integer sifra) {
            super(sifra);
            this.cijena = cijena;
            this.prodajnomjesto = prodajnomjesto;
            this.proizvodac = proizvodac;
            this.model = model;
            this.VIN = VIN;
        }

        public String getVIN() {
            return VIN;
        }

        public void setVIN(String VIN) {
            this.VIN = VIN;
        }

        
	public Vozilo() {
		// TODO Auto-generated constructor stub
	}


	public BigDecimal getCijena() {
		return cijena;
	}


	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}


	public ProdajnoMjesto getProdajnomjesto() {
		return prodajnomjesto;
	}


	public void setProdajnomjesto(ProdajnoMjesto prodajnomjesto) {
		this.prodajnomjesto = prodajnomjesto;
	}

        public String getProizvodac() {
            return proizvodac;
        }

        public void setProizvodac(String proizvodac) {
            this.proizvodac = proizvodac;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

    @Override
    public String toString() {
        return getProizvodac() + " " + getModel() + " " + getVIN();
    }

        
        
	

	
}
