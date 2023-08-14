package autokuca.model;

public class Racun extends Vozilo {
	private Kupac kupac;
	private Prodavac prodavac;
	private Vozilo vozilo;

	public Racun() {
		super();
	}

	

	public Racun(int sifra, String ime, String prezime, String adresa, String naziv, Prodavac prodavac, float cijena,
			ProdajnoMjesto prodajnomjesto, Kupac kupac, Prodavac prodavac2, Vozilo vozilo) {
		super(sifra, ime, prezime, adresa, naziv, prodavac, cijena, prodajnomjesto);
		this.kupac = kupac;
		prodavac = prodavac2;
		this.vozilo = vozilo;
	}



	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public Prodavac getProdavac() {
		return prodavac;
	}

	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	

}
