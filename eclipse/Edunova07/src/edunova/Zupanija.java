package edunova;

public class Zupanija {
	private String naziv;
	private int brojStanovnika;
	
	
	
	public Zupanija() {
		super();
	}


	public Zupanija(String naziv, int brojStanovnika) {
		super();
		this.naziv = naziv;
		this.brojStanovnika = brojStanovnika;
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getBrojStanovnika() {
		return brojStanovnika;
	}
	public void setBrojStanovnika(int brojStanovnika) {
		this.brojStanovnika = brojStanovnika;
	}
	

}
