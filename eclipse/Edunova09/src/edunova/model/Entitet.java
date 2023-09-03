package edunova.model;

public abstract class Entitet {
	
	public Entitet() {
		
	}
	
	
	
	public Entitet(int sifra) {
		super();
		this.sifra = sifra;
	}



	private int sifra;

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

}
