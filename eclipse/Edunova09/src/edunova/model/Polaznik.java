package edunova.model;

public class Polaznik extends Osoba {

	private String brojUgovora;

	public Polaznik() {
		super();
	}

	public Polaznik(int sifra, String ime, String prezime, String oib, String email, String brojUgovora) {
		super(sifra, ime, prezime, oib, email);
		this.brojUgovora = brojUgovora;
	}

	public String getBrojUgovora() {
		return brojUgovora;
	}

	public void setBrojUgovora(String brojUgovora) {
		this.brojUgovora = brojUgovora;
	}

}
