package autokuca.model;

import java.util.List;

public class Vozilo extends Entitet{
	private float cijena;
	private ProdajnoMjesto prodajnomjesto;
	
	
	

	


	public Vozilo(int sifra, float cijena, ProdajnoMjesto prodajnomjesto) {
		super(sifra);
		this.cijena = cijena;
		this.prodajnomjesto = prodajnomjesto;
	}


	public Vozilo() {
		// TODO Auto-generated constructor stub
	}


	public float getCijena() {
		return cijena;
	}


	public void setCijena(float cijena) {
		this.cijena = cijena;
	}


	public ProdajnoMjesto getProdajnomjesto() {
		return prodajnomjesto;
	}


	public void setProdajnomjesto(ProdajnoMjesto prodajnomjesto) {
		this.prodajnomjesto = prodajnomjesto;
	}


	

	
}
