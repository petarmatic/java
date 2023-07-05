package edunova;

public class Smjer {
	private int sifra;
	private String naziv;
	private float cijena;
	private boolean certificiran;
	
	
	
	public Smjer() {
		super();
	}
	public Smjer(int sifra, String naziv, float cijena, boolean certificiran) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
		this.certificiran = certificiran;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public float getCijena() {
		return cijena;
	}
	public void setCijena(float cijena) {
		this.cijena = cijena;
	}
	public boolean isCertificiran() {
		return certificiran;
	}
	public void setCertificiran(boolean certificiran) {
		this.certificiran = certificiran;
	}

}
