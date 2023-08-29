package edunova.model;

import jakarta.persistence.Entity;

@Entity
public class Smjer extends Entitet {
	
	private String naziv;
	private float cijena;
	private float upisnina;
	private int trajanje;
	private boolean verificiran;
	
	
	
	
	public Smjer() {
		
	}
	public Smjer(int sifra, String naziv, float cijena, float upisnina, int trajanje, boolean verificiran) {
		super(sifra);
		this.naziv = naziv;
		this.cijena = cijena;
		this.upisnina = upisnina;
		this.trajanje = trajanje;
		this.verificiran = verificiran;
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
	public float getUpisnina() {
		return upisnina;
	}
	public void setUpisnina(float upisnina) {
		this.upisnina = upisnina;
	}
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	public boolean isVerificiran() {
		return verificiran;
	}
	public void setVerificiran(boolean verificiran) {
		this.verificiran = verificiran;
	}
	
	@Override
	public String toString() {
		
		return sifra + " " + naziv+ " " + cijena+ " " + upisnina+
				" "+ trajanje + " " + verificiran;
	}

}
