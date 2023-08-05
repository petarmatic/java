package autokuca.model;

public abstract class Entitet {
	protected int sifra;

	

	

	public Entitet() {
		super();
	}

	public Entitet(int sifra) {
		super();
		this.sifra = sifra;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	@Override
	public String toString() {
		
		return sifra + " ";
	}
}
