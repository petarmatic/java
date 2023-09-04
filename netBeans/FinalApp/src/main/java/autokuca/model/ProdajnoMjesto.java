package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.List;


@Entity
public class ProdajnoMjesto extends Entitet {
	private String adresa;
	private String naziv;
        @ManyToOne
	private Prodavac prodavac;
	
	
	
	
	
	
	public ProdajnoMjesto(Integer sifra, String adresa, String naziv, Prodavac prodavac) {
		super(sifra);
		this.adresa = adresa;
		this.naziv = naziv;
		this.prodavac = prodavac;
	}

	public ProdajnoMjesto() {
		super();
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Prodavac getProdavac() {
		return prodavac;
	}

	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}
	
	

	
	
	

	
}