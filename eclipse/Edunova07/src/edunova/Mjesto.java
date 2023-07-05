package edunova;

public class Mjesto {
	private String naziv;
	private String postanskiBroj;
	private Zupanija zupanija;
	
	
	
	
	public Mjesto() {
		super();
	}
	public Mjesto(String naziv, String postanskiBroj, Zupanija zupanija) {
		super();
		this.naziv = naziv;
		this.postanskiBroj = postanskiBroj;
		this.zupanija = zupanija;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public Zupanija getZupanija() {
		return zupanija;
	}
	public void setZupanija(Zupanija zupanija) {
		this.zupanija = zupanija;
	}
	
	
}
