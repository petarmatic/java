package autokuca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class Racun extends Entitet{
        @ManyToOne
	private Kupac kupac;
        @ManyToOne
	private  Prodavac prodavac;
        @ManyToOne
	private Vozilo vozilo;
	
	
	
	
	
	
	public Racun() {
		super();
	}
	public Racun(Integer sifra, Kupac kupac, Prodavac prodavac, Vozilo vozilo) {
		super(sifra);
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
