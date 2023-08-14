package autokuca.model;

public class Kupac extends Entitet {
	private float budzet;
	private String ime;
	private String prezime;
	
	
	
	
	

	public Kupac() {
		super();
	}

	
	public Kupac(int sifra, float budzet, String ime, String prezime) {
		super(sifra);
		this.budzet = budzet;
		this.ime = ime;
		this.prezime = prezime;
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

	
}
