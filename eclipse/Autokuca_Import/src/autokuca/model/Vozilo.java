package autokuca.model;

public class Vozilo extends ProdajnoMjesto {
	private float cijena;
	private ProdajnoMjesto prodajnomjesto;

	public Vozilo(int i, String string, String string2, String string3, String string4, int j, float f, int k) {
		super();
	}

	
	public Vozilo(int sifra, String ime, String prezime, String adresa, String naziv, Prodavac prodavac, float cijena,
			ProdajnoMjesto prodajnomjesto) {
//		super(sifra, ime, prezime, adresa, naziv, prodavac);
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
