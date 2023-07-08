package Zadatak;

public class Vozilo extends ProdajnoMjesto {
	private float cijena;
	private ProdajnoMjesto prodajnomjesto;
	
	
	
	
	public Vozilo() {
		super();
	}
	public Vozilo(float cijena, ProdajnoMjesto prodajnomjesto) {
		super();
		this.cijena = cijena;
		this.prodajnomjesto = prodajnomjesto;
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
