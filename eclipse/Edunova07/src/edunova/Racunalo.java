package edunova;

public class Racunalo {
	
	private String nazivProc;
	private float cijena;
	private int RAM;
	
	
	
	
	public Racunalo() {
		super();
	}
	public Racunalo(String nazivProc, float cijena, int rAM) {
		super();
		this.nazivProc = nazivProc;
		this.cijena = cijena;
		RAM = rAM;
	}
	public String getNazivProc() {
		return nazivProc;
	}
	public void setNazivProc(String nazivProc) {
		this.nazivProc = nazivProc;
	}
	public float getCijena() {
		return cijena;
	}
	public void setCijena(float cijena) {
		this.cijena = cijena;
	}
	public int getRAM() {
		return RAM;
	}
	public void setRAM(int rAM) {
		RAM = rAM;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
