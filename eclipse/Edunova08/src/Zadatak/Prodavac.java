package Zadatak;

public abstract class Prodavac extends Entitet{
	 private String ime;
	 private String prezime;
	 
	 
	 
	public Prodavac() {
		super();
	}
	public Prodavac(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	 
	 

}
