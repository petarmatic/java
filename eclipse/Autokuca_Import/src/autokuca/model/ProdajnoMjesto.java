package autokuca.model;

public class ProdajnoMjesto extends Prodavac{
	private String adresa;
	private String naziv;
	private Prodavac prodavac;
	
	
	
	public ProdajnoMjesto() {
		super();
	}
	public ProdajnoMjesto(String adresa, String naziv, Prodavac prodavac) {
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
