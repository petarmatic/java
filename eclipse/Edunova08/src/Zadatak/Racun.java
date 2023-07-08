package Zadatak;

public class Racun extends Vozilo {
	private Kupac kupac;
	private Prodavac prodavac;
	private Vozilo vozilo;
	
	
	
	
	public Racun() {
		super();
	}
	public Racun(Kupac kupac, Prodavac prodavac, Vozilo vozilo) {
		super();
		this.kupac = kupac;
		this.prodavac = prodavac;
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
