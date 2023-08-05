package autokuca.model;

public class Kupac extends Entitet{
	 private float budzet;
	 private String ime;
	 private String prezime;
	 
	 
	 
	 
	
	
	public Kupac(int i, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public Kupac() {
		// TODO Auto-generated constructor stub
	}
	public float getBudzet() {
		return budzet;
	}
	public void setBudzet(float budzet) {
		this.budzet = budzet;
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
	 
	 @Override
	public String toString() {
		
		return budzet + " " + ime + " " + prezime;
	}
}
