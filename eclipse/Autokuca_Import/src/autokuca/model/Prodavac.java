package autokuca.model;

public class Prodavac extends Entitet {

	private String ime;
	private String prezime;

	public Prodavac() {
		super();
	}

	public Prodavac(int sifra, String ime, String prezime) {
		super(sifra);
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

	@Override
	public String toString() {

		return sifra + " " + ime + " " + prezime;
	}

}
