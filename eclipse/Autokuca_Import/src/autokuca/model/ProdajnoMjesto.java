package autokuca.model;

import java.util.List;

public class ProdajnoMjesto extends Prodavac {
	private String adresa;
	private String naziv;
	private Prodavac prodavac;
	
	
	
	
	
	public ProdajnoMjesto() {
		super();
	}
	public ProdajnoMjesto(int sifra, String ime, String prezime, String adresa, String naziv, Prodavac prodavac) {
		super(sifra, ime, prezime);
		this.adresa = adresa;
		this.naziv = naziv;
		this.prodavac = prodavac;
	}
	public ProdajnoMjesto(int i, String string, String string2, Prodavac prodavac2) {
		// TODO Auto-generated constructor stub
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
	public List<Prodavac> getProdavac() {
		return (List<Prodavac>) prodavac;
	}
	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}

	
	
	

	
}