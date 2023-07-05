package edunova;

public class Grad {
	private String ime;
	private int postanskiBroj;
	private boolean trgovina;
	private float prosjecnaPlaca;
	private char energetskiCertifikat;
	
	
	
	
	
	
	public Grad() {
		super();
	}
	public Grad(String ime, int postanskiBroj, boolean trgovina, float prosjecnaPlaca, char energetskiCertifikat) {
		super();
		this.ime = ime;
		this.postanskiBroj = postanskiBroj;
		this.trgovina = trgovina;
		this.prosjecnaPlaca = prosjecnaPlaca;
		this.energetskiCertifikat = energetskiCertifikat;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public boolean isTrgovina() {
		return trgovina;
	}
	public void setTrgovina(boolean trgovina) {
		this.trgovina = trgovina;
	}
	public float getProsjecnaPlaca() {
		return prosjecnaPlaca;
	}
	public void setProsjecnaPlaca(float prosjecnaPlaca) {
		this.prosjecnaPlaca = prosjecnaPlaca;
	}
	public char getEnergetskiCertifikat() {
		return energetskiCertifikat;
	}
	public void setEnergetskiCertifikat(char energetskiCertifikat) {
		this.energetskiCertifikat = energetskiCertifikat;
	}
	
	
	
	
	
	
	
	

}
