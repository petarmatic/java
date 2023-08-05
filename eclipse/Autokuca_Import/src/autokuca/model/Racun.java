package autokuca.model;

public class Racun extends Vozilo {
	private Kupac kupac;
	private Prodavac prodavac;
	private Vozilo vozilo;
	
	
	
	

	public Racun(int sifra, String ime, String prezime) {
		super(sifra, ime, prezime);
	}

	

	public Racun(int sifra, String ime, String prezime, Kupac kupac, Prodavac prodavac, Vozilo vozilo) {
		super(sifra, ime, prezime);
		this.kupac = kupac;
		this.prodavac = prodavac;
		this.vozilo = vozilo;
	}



	public Racun() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {

		return kupac + " " + prodavac + " " + vozilo;
	}

}
