package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Prodavac extends Entitet {

	private String ime;
	private String prezime;
        
        
        
        @OneToMany(mappedBy = "prodavac")
        private List<Racun> racuni= new ArrayList<>();
        
        @OneToMany(mappedBy = "prodavac")
        private List<ProdajnoMjesto> prodajnoMjesto=new ArrayList<>();

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }

    public List<ProdajnoMjesto> getProdajnoMjesto() {
        return prodajnoMjesto;
    }

    public void setProdajnoMjesto(List<ProdajnoMjesto> prodajnoMjesto) {
        this.prodajnoMjesto = prodajnoMjesto;
    }

   

   
        

	public Prodavac() {
		super();
        this.racuni = new ArrayList<>();
        this.prodajnoMjesto = new ArrayList<>();
	}

	public Prodavac(Integer sifra, String ime, String prezime) {
		super(sifra);
        this.racuni = new ArrayList<>();
        this.prodajnoMjesto = new ArrayList<>();
		this.ime = ime;
		this.prezime = prezime;
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

	@Override
	public String toString() {

		return ime + " " + prezime;
	}
        
        

}


