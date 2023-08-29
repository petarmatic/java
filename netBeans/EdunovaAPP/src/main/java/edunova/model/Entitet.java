package edunova.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Entitet {
	
	
	
	
	public Entitet() {
		
	}

	public Entitet(int sifra) {
		super();
		this.sifra = sifra;
	}
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int sifra;

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

}
