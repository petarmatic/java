package autokuca.model;

import java.util.List;

public class Racun extends Vozilo {
	private List<Kupac> kupac;
	private List<Prodavac> prodavac;
	private List<Vozilo> vozilo;
	
	
	
	
	public Racun() {
		super();
	}
	public Racun(int sifra, String ime, String prezime, String adresa, String naziv, List<Prodavac> prodavac, float cijena,
			ProdajnoMjesto prodajnomjesto, List<Kupac> kupac, List<Prodavac> prodavac2, List<Vozilo> vozilo) {
		super(sifra, ime, prezime, adresa, naziv, prodavac, cijena, prodajnomjesto);
		this.kupac = kupac;
		prodavac = prodavac2;
		this.vozilo = vozilo;
	}
	public List<Kupac> getKupac() {
		return kupac;
	}
	public void setKupac(List<Kupac> kupac) {
		this.kupac = kupac;
	}
	public List<Prodavac> getProdavac() {
		return prodavac;
	}
	public void setProdavac(List<Prodavac> prodavac) {
		this.prodavac = prodavac;
	}
	public List<Vozilo> getVozilo() {
		return vozilo;
	}
	public void setVozilo(List<Vozilo> vozilo) {
		this.vozilo = vozilo;
	}

	
	

}
