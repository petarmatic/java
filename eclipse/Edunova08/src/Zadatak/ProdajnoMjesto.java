package Zadatak;

public class ProdajnoMjesto extends Prodavac{
	private String adresa;
	private int naziv;
	private Prodavac prodavac;
	
	
	public ProdajnoMjesto() {
		super();
	}
	public ProdajnoMjesto(String adresa, int naziv, Prodavac prodavac) {
		super();
		this.adresa = adresa;
		this.naziv = naziv;
		this.prodavac = prodavac;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public int getNaziv() {
		return naziv;
	}
	public void setNaziv(int naziv) {
		this.naziv = naziv;
	}
	public Prodavac getProdavac() {
		return prodavac;
	}
	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}
	
	
}
